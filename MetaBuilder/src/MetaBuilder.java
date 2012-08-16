import java.util.StringTokenizer;

/**
 *
 */
public class MetaBuilder {


    public static void main(String args[]) {
        System.out.println(build(addressWidgetMetas()));

    }

    private static String build(String s) {
        StringBuffer sb = new StringBuffer();
        StringTokenizer st = new StringTokenizer(s, " ");
        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            sb.append("private final MetaObject ");
            sb.append(token.toUpperCase());
            sb.append(" = new MetaObject(\"");
            sb.append(token.toUpperCase());
            sb.append("\", null, ");
            sb.append(getFactoryName(token));
            sb.append(");\n");
        }
        return sb.toString();
    }

    private static String getFactoryName(String token) {
        StringBuffer sb = new StringBuffer();
        sb.append("new ");
        StringTokenizer st = new StringTokenizer(token, "_");
        boolean first = true;

        StringBuffer factoryName = new StringBuffer();
        while (st.hasMoreTokens()) {
            if (first) {
                first = false;
                st.nextToken();
            }
            else {
                String s = st.nextToken();
                    factoryName.append(s.substring(0, 1).toUpperCase());
                    factoryName.append(s.substring(1).toLowerCase());
            }

        }
        factoryName.append("Factory");
        String fName = factoryName.toString();
        sb.append(fName);
        sb.append(getConstructorVars(fName));
        return sb.toString();
    }

    private static String getConstructorVars(String factory){
        if(factory.equalsIgnoreCase("RoundedPanelFactory")){
            return "(RoundedPanel.ALL, 5)";
        }
        return "()";
    }

    private static String addressWidgetMetas() {
        return "outer_rounded_panel " +
                "content_vertical_panel " +
                "data_flex_table " +
                "country_label " +
                "country_text_box " +
                "address_label " +
                "address_text_box " +
                "city_label " +
                "city_text_box " +
                "citycode_label " +
                "citycode_text_box ";

    }


}
