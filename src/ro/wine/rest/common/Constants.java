package ro.wine.rest.common;

public class Constants {
	public final static String FREEBASE_KEY = "AIzaSyBMPizACx2RPVuHnUfzcmZ2TauMCDC_u9g";
	public final static String BASIC_FIELDS="\"id\":null,"
			+ "\"name\":null,"
			+ "\"wine_producer\":null,"
			+ "\"vintage\":null,"
			+ "\"color\":null,"
			+ "\"wine_type\":null,"
			+ "\"percentage_alcohol\":null,"
			+ "\"fruit_source\":null,"
			+ "\"country\":null,"
			+ "\"region\":null,"
			+ "\"wine_sub_region\":null,"
			+ "\"vineyard\":null,";
	public final static String QUERY_START="[{";
	public final static String QUESRY_END="}]";
	public final static String TYPE_WINE_TYPE="\"type\": \"/wine/wine_type\",";
	public final static String TYPE_WINE="\"type\": \"/wine/wine\"";
	//public final static String TYPE_WINE="\"type\": \"/wine/wine\"";
	
	//fields name 
	public final static String FLD_ID="id";
	public final static String FLD_NAME="name";
	public final static String FLD_VINTAGE="vintage";
	public final static String FLD_COLOR="color";
	public final static String FLD_ALCOHOL="percentage_alcohol";
	public final static String FLD_FRUIT_S="fruit_source";
	public final static String FLD_COUNTRY="country";
	public final static String FLD_REGION="region";
	public final static String FLD_SUBREGION="wine_sub_region";
	public final static String FLD_WINE_TYPE="wine_type";
	public final static String FLD_VINEYARD="vineyard";
	public final static String FLD_PRODUCER="producer";
	
	//query
	public final static String QUERY_SEARCH="\"name~=\": \"%s\",";
	public final static String QUERY_WINE_ID="\"ns0:id\": \"/en/%s\",";
	public final static String QUERY_WINE_NAME="\"ns0:name~=\": \"%s\",";
	public final static String QUERY_WINE_VINTAGE="\"ns0:vintage\": \"%s\",";
	public final static String QUERY_WINE_COLOR="\"ns0:color\": \"%s\",";
	public final static String QUERY_WINE_ALCOHOL="\"ns0:percentage_alcohol\": %s,";
	public final static String QUERY_WINE_FRUIT_S="\"ns0:fruit_source\": \"%s\",";
	public final static String QUERY_WINE_COUNTRY="\"ns0:country~=\": \"%s\",";
	public final static String QUERY_WINE_REGION="\"ns0:region~=\": \"%s\",";
	public final static String QUERY_WINE_SUBREGION="\"ns0:wine_sub_region~=\": \"%s\",";
	public final static String QUERY_WINE_TYPE="\"ns0:wine_type\": \"%s\",";
	public final static String QUERY_WINE_VINEYARD="\"ns0:vineyard~=\": \"%s\",";
	public final static String QUERY_WINE_PRODUCER="\"ns0:wine_producer~=\": \"%s\",";
}
