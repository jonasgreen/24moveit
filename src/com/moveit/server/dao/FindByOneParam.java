package com.moveit.server.dao;


/**
 *
 */
public class FindByOneParam {

    public enum Operator {
        LESS_THAN("<"),
        LESS_THAN_OR_EQUAL_TO("<="),
        EQUAL_TO("=="),
        GREATER_THAN(">"),
        GREATER_THAN_OR_EQUAL(">="),
        NOT_EQUAL_TO("!=");

        private final String operator;

        private Operator(String operator) {
            this.operator = operator;
        }

        public String getOperator() {
            return operator;
        }
    }


    public static FindByOneParam findByEmail(){
       return new FindByOneParam("String", "email");
    }

    public static FindByOneParam findCounterByKey(){
        return new FindByOneParam("Integer", "key");
    }

    public static FindByOneParam findRoutesByUserId(){
        return new FindByOneParam("Long", "userId");
    }


    public static FindByOneParam findRoutesByCounter(){
        return new FindByOneParam("Long", "counter");
    }

    public static FindByOneParam findRoutesByCreatedDateGreaterThan(){
        return new FindByOneParam("java.util.Date", "createdDate", Operator.GREATER_THAN);
    }

    public static FindByOneParam findRoutesByTodateGreaterThan(){
        return new FindByOneParam("java.util.Date", "toDate", Operator.GREATER_THAN);
    }

    public static FindByOneParam findSubscribtionsByUserid(){
        return new FindByOneParam("Long", "userId");
    }
    public static FindByOneParam findSubscriptionsByMailList(){
        return new FindByOneParam("Integer", "mailList");
    }


    private String filter;
    private String declaredParameters;
    private String ordering;
    private String paramClass;
    private String columnName;
    private String parameterName;
    private Object value;

    public FindByOneParam(String paramClass, String colNam) {
        this(paramClass, colNam, "==");
    }

    public FindByOneParam(String paramClass, String colNam, Operator operator) {
        this(paramClass, colNam, operator.getOperator());
    }


    public FindByOneParam(String paramClass, String colNam, String operator) {
        this.paramClass = paramClass;
        this.columnName = colNam;
        this.parameterName = columnName + "Param";
        this.filter = columnName + " " + operator + " " + parameterName;
        this.declaredParameters = paramClass + " " + parameterName;
    }

    public String getFilter() {
        return filter;
    }

    public String getDeclaredParameters() {
        return declaredParameters;
    }

    public String getOrdering() {
        return ordering;
    }

    public String getParamClass() {
        return paramClass;
    }

    public String getColumnName() {
        return columnName;
    }

    public String getParameterName() {
        return parameterName;
    }


    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public void setOrdering(String ordering) {
        this.ordering = ordering;
    }

    @Override
    public String toString() {
        return "FindByOneParam{" +
                "filter='" + filter + '\'' +
                ", declaredParameters='" + declaredParameters + '\'' +
                ", ordering='" + ordering + '\'' +
                ", paramClass='" + paramClass + '\'' +
                ", columnName='" + columnName + '\'' +
                ", parameterName='" + parameterName + '\'' +
                ", value=" + value +
                '}';
    }
}
