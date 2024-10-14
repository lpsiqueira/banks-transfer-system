package lucas.banks_transfer_system.externalAPIs;

public interface ExternalAPIs<ReturnDataType, FilterDataType/* , ConfigurationDataType */> {
	//public setConectionConfiguration(ConfigurationDataType instituitionAPIData);
	public Boolean authenticate();
	public ReturnDataType getData(FilterDataType filter);
}
