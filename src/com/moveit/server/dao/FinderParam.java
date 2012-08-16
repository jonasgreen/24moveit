package com.moveit.server.dao;

/**
 *
 */
public class FinderParam {

    private Class modelClass;
    private String paramClass;
    private String columnName;
    private Object value;

    private FinderParam(Class modelClass, String clName, String cName) {
        this.modelClass = modelClass;
        this.paramClass =clName;
        this.columnName = cName;
    }

    public static FinderParam get(Class modelClass, String className, String colName){
        return new FinderParam(modelClass, className, colName);
    }


    public String getColumnName() {
        return columnName;
    }

    public Object getValue() {
        return value;
    }

    public String getParamClass() {
        return paramClass;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Class getModelClass() {
        return modelClass;
    }
}
