package com.niezhili.dataplatform.metadata;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

/**
 * https://blog.csdn.net/weixin_42728895/article/details/105033073
 */
public class DatabaseMetaUtil {

    private final static String DATABASE_NAME = "dolphinscheduler";

    private DatabaseMetaData dbMetaData = null;
    private Connection con = null;

    public DatabaseMetaUtil() {
        this.getDatabaseMetaData();
    }

    private void getDatabaseMetaData() {
        try {
            if (dbMetaData == null) {
                Class.forName("com.mysql.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/" + DATABASE_NAME;
                String user = "root";
                String password = "root";
                con = DriverManager.getConnection(url, user, password);
                dbMetaData = con.getMetaData();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获得数据库的一些相关信息
     */
    public void getDataBaseInformations() {
        try {
            System.out.println("数据库已知的用户" + dbMetaData.getUserName());
            System.out.println("数据库的系统函数的逗号分隔列表:" + dbMetaData.getSystemFunctions());
            System.out.println("数据库的时间和日期函数的逗号分隔列表: " + dbMetaData.getTimeDateFunctions());
            System.out.println("数据库的字符串函数的逗号分隔列表: " + dbMetaData.getStringFunctions());
            System.out.println("数据库供应商用于'schema' 的首选术语: " + dbMetaData.getSchemaTerm());
            System.out.println("数据库URL: " + dbMetaData.getURL());
            System.out.println("是否允许只读:" + dbMetaData.isReadOnly());
            System.out.println("数据库的产品名称:" + dbMetaData.getDatabaseProductName());
            System.out.println("数据库的版本:" + dbMetaData.getDatabaseProductVersion());
            System.out.println("驱动程序的名称:" + dbMetaData.getDriverName());
            System.out.println("驱动程序的版本:" + dbMetaData.getDriverVersion());

            System.out.println();
            System.out.println("数据库中使用的表类型");
            ResultSet rs = dbMetaData.getTableTypes();
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
            rs.close();
            System.out.println();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获得该用户下面的所有表
     */
    public void getAllTableList(String schemaName) {
        try {
            // table type. Typical types are "TABLE","VIEW", "SYSTEM TABLE";,
            // "GLOBAL TEMPORARY", "LOCAL TEMPORARY", "ALIAS", "SYNONYM".
            String[] types = {"TABLE"};
            ResultSet rs = dbMetaData.getTables(null, schemaName, "%", types);
            while (rs.next()) {
                String tableName = rs.getString("TABLE_NAME"); // 表名
                String tableType = rs.getString("TABLE_TYPE"); // 表类型
                String remarks = rs.getString("REMARKS"); // 表备注
                System.out.println(tableName + "-" + tableType + "-" + remarks);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获得该用户下面的所有视图
     */
    public void getAllViewList(String schemaName) {
        try {
            String[] types = {"VIEW"};
            ResultSet rs = dbMetaData.getTables(null, schemaName, "%", types);
            while (rs.next()) {
                String viewName = rs.getString("TABLE_NAME"); // 视图名
                String viewType = rs.getString("TABLE_TYPE"); // 视图类型
                String remarks = rs.getString("REMARKS"); // 视图备注
                System.out.println(viewName + "-" + viewType + "-" + remarks);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获得数据库中所有方案名称
     */
    public void getAllSchemas() {
        try {
            ResultSet rs = dbMetaData.getSchemas();
            while (rs.next()) {
                String tableSchem = rs.getString("TABLE_SCHEM");
                System.out.println(tableSchem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据指定用户名与表名获取其中列字段名
     *
     * @param schemaName
     * @param tableName
     * @return
     */
    public Map<String, Field> getColumnNameBySchemaNameAndTableName(String schemaName, String tableName) {
        Map<String, Field> columns = null;
        try {
            columns = new HashMap<>();
            ResultSet rs = dbMetaData.getColumns(null, schemaName, tableName, "%");
            while (rs.next()) {
                String columnName = rs.getString("COLUMN_NAME");// 列名
                String dataTypeName = rs.getString("TYPE_NAME");// java.sql.Types类型名称
                int columnSize = rs.getInt("COLUMN_SIZE");// 列大小
                Field field = new Field(columnName, dataTypeName, columnSize);
                columns.put(columnName, field);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return columns;
    }

    /**
     * 获得一个表的主键信息
     */
    public String getPrimaryKeyBySchemaNameAndTableName(String schemaName, String tableName) {
        String primaryKey = null;
        try {
            ResultSet rs = dbMetaData.getPrimaryKeys(null, schemaName, tableName);
            while (rs.next()) {
                primaryKey = rs.getString("COLUMN_NAME");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return primaryKey;
    }


    /**
     * 获得表或视图中的所有列信息
     */
    public void getTableColumns(String schemaName, String tableName) {

        try {

            ResultSet rs = dbMetaData.getColumns(null, schemaName, tableName, "%");
            while (rs.next()) {
                String tableCat = rs.getString("TABLE_CAT");// 表目录(可能为空);
                String tableSchemaName = rs.getString("TABLE_SCHEM");// 表的架构(可能为空);
                String tableName_ = rs.getString("TABLE_NAME");// 表名
                String columnName = rs.getString("COLUMN_NAME");// 列名
                int dataType = rs.getInt("DATA_TYPE"); // 对应的java.sql.Types类型
                String dataTypeName = rs.getString("TYPE_NAME");// java.sql.Types类型
                // 名称
                int columnSize = rs.getInt("COLUMN_SIZE");// 列大小
                int decimalDigits = rs.getInt("DECIMAL_DIGITS");// 小数位数
                int numPrecRadix = rs.getInt("NUM_PREC_RADIX");// 基数(通常是10或2);
                int nullAble = rs.getInt("NULLABLE");// 是否允许为null
                String remarks = rs.getString("REMARKS");// 列描述
                String columnDef = rs.getString("COLUMN_DEF");// 默认值
                int sqlDataType = rs.getInt("SQL_DATA_TYPE");// sql数据类型
                int sqlDatetimeSub = rs.getInt("SQL_DATETIME_SUB"); // SQL日期时间分?
                int charOctetLength = rs.getInt("CHAR_OCTET_LENGTH"); // char类型的列中的最大字节数
                int ordinalPosition = rs.getInt("ORDINAL_POSITION"); // 表中列的索引(从1开始);

                /**
                 * ISO规则用来确定某一列的为空性。 是---如果该参数可以包括空值; 无---如果参数不能包含空值
                 * 空字符串---如果参数为空性是未知的
                 */
                String isNullAble = rs.getString("IS_NULLABLE");

                /**
                 * 指示此列是否是自动递增 是---如果该列是自动递增 无---如果不是自动递增列 空字串---如果不能确定它是否
                 * 列是自动递增的参数是未知
                 */
                String isAutoincrement = rs.getString("IS_AUTOINCREMENT");

                System.out.println(tableCat + "-" + tableSchemaName + "-" + tableName_ + "-" + columnName + "-"
                        + dataType + "-" + dataTypeName + "-" + columnSize + "-" + decimalDigits + "-" + numPrecRadix
                        + "-" + nullAble + "-" + remarks + "-" + columnDef + "-" + sqlDataType + "-" + sqlDatetimeSub
                        + charOctetLength + "-" + ordinalPosition + "-" + isNullAble + "-" + isAutoincrement + "-");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获得一个表的索引信息
     */
    public void getIndexInfo(String schemaName, String tableName) {
        try {
            ResultSet rs = dbMetaData.getIndexInfo(null, schemaName, tableName, true, true);
            while (rs.next()) {
                boolean nonUnique = rs.getBoolean("NON_UNIQUE");// 非唯一索引(Can
                // index values
                // be
                // non-unique.
                // false when
                // TYPE is
                // tableIndexStatistic
                // )
                String indexQualifier = rs.getString("INDEX_QUALIFIER");// 索引目录（可能为空）;
                String indexName = rs.getString("INDEX_NAME");// 索引的名称
                short type = rs.getShort("TYPE");// 索引类型
                short ordinalPosition = rs.getShort("ORDINAL_POSITION");// 在索引列顺序号
                String columnName = rs.getString("COLUMN_NAME");// 列名
                String ascOrDesc = rs.getString("ASC_OR_DESC");// 列排序顺序:升序还是降序
                int cardinality = rs.getInt("CARDINALITY"); // 基数
                System.out.println(nonUnique + ";-" + indexQualifier + "-" + indexName + "-" + type + "-"
                        + ordinalPosition + "-" + columnName + "-" + ascOrDesc + "-" + cardinality);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获得一个表的主键信息
     */
    public void getAllPrimaryKeys(String schemaName, String tableName) {
        try {
            ResultSet rs = dbMetaData.getPrimaryKeys(null, schemaName, tableName);
            while (rs.next()) {
                String columnName = rs.getString("COLUMN_NAME");// 列名
                short keySeq = rs.getShort("KEY_SEQ");// 序列号(主键内值1表示第一列的主键&#xff0c;值2代表主键内的第二列)
                String pkName = rs.getString("PK_NAME"); // 主键名称
                System.out.println(columnName + "-" + keySeq + "-" + pkName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获得一个表的外键信息
     */
    public void getAllExportedKeys(String schemaName, String tableName) {

        try {
            ResultSet rs = dbMetaData.getExportedKeys(null, schemaName, tableName);
            while (rs.next()) {
                String pkTableCat = rs.getString("PKTABLE_CAT");// 主键表的目录&#xff08;可能为空&#xff09;
                String pkTableSchem = rs.getString("PKTABLE_SCHEM");// 主键表的架构&#xff08;可能为空&#xff09;
                String pkTableName = rs.getString("PKTABLE_NAME");// 主键表名
                String pkColumnName = rs.getString("PKCOLUMN_NAME");// 主键列名
                String fkTableCat = rs.getString("FKTABLE_CAT");// 外键的表的目录&#xff08;可能为空&#xff09;出口&#xff08;可能为null&#xff09;
                String fkTableSchem = rs.getString("FKTABLE_SCHEM");// 外键表的架构&#xff08;可能为空&#xff09;出口&#xff08;可能为空&#xff09;
                String fkTableName = rs.getString("FKTABLE_NAME");// 外键表名
                String fkColumnName = rs.getString("FKCOLUMN_NAME"); // 外键列名
                short keySeq = rs.getShort("KEY_SEQ");// 序列号&#xff08;外键内值1表示第一列的外键&#xff0c;值2代表在第二列的外键&#xff09;。

                short updateRule = rs.getShort("UPDATE_RULE");


                short delRule = rs.getShort("DELETE_RULE");
                String fkName = rs.getString("FK_NAME");// 外键的名称&#xff08;可能为空&#xff09;
                String pkName = rs.getString("PK_NAME");// 主键的名称&#xff08;可能为空&#xff09;

                short deferRability = rs.getShort("DEFERRABILITY");

                System.out.println(pkTableCat + "-" + pkTableSchem + "-" + pkTableName + "-" + pkColumnName + "-"
                        + fkTableCat + "-" + fkTableSchem + "-" + fkTableName + "-" + fkColumnName + "-" + keySeq + "-"
                        + updateRule + "-" + delRule + "-" + fkName + "-" + pkName + "-" + deferRability);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void colseCon() {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        DatabaseMetaUtil metaData = new DatabaseMetaUtil();
        metaData.getDataBaseInformations();
        metaData.getAllTableList(null);
        metaData.getAllViewList(null);
        metaData.getAllSchemas();
        // metaData.getTableColumns("root", "gen_person");
        // System.out.println("=======================");
        // metaData.getIndexInfo("root", "gen_person");
        // System.out.println("=======================");
        metaData.getAllPrimaryKeys("root", "t_ds_project");
        // System.out.println("=======================");
        // metaData.getAllExportedKeys("root", "gen_person");
        // System.out.println("=======================");
        // Map&lt;String, Field&gt; columnNameBySchemaNameAndTableName =
        // metaData.getColumnNameBySchemaNameAndTableName("root", "gen_person");
        // Set&lt;Entry&lt;String, Field&gt;&gt; entrySet =
        // columnNameBySchemaNameAndTableName.entrySet();
        // for (Entry&lt;String, Field&gt; entry : entrySet) {
        // System.out.println("key:" +; entry.getKey());
        // System.out.println("value:" +; entry.getValue().toString());
        // }
    }
}

