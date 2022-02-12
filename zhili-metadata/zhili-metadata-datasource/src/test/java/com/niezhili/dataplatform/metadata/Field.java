package com.niezhili.dataplatform.metadata;


public class Field {

    private String fieldName;
    private String fieldType;
    private Integer fieldLength;

    public Field() {
    }

    public Field(String fieldName, String fieldType, Integer fieldLength) {
        this.fieldName = fieldName;
        this.fieldType = fieldType;
        this.fieldLength = fieldLength;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public Integer getFieldLength() {
        return fieldLength;
    }

    public void setFieldLength(Integer fieldLength) {
        this.fieldLength = fieldLength;
    }

    @Override
    public String toString() {
        return "Field [fieldName=" + fieldName + ", fieldType=" + fieldType + ", fieldLength" + fieldLength + "]";
    }
}