package edu.matc.googleMaps;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class ResultsItem{

	@JsonProperty("formatted_address")
	private String formattedAddress;

	@JsonProperty("types")
	private List<String> types;

	@JsonProperty("partial_match")
	private boolean partialMatch;

	@JsonProperty("geometry")
	private Geometry geometry;

	@JsonProperty("address_components")
	private List<AddressComponentsItem> addressComponents;

	@JsonProperty("place_id")
	private String placeId;

	public void setFormattedAddress(String formattedAddress){
		this.formattedAddress = formattedAddress;
	}

	public String getFormattedAddress(){
		return formattedAddress;
	}

	public void setTypes(List<String> types){
		this.types = types;
	}

	public List<String> getTypes(){
		return types;
	}

	public void setPartialMatch(boolean partialMatch){
		this.partialMatch = partialMatch;
	}

	public boolean isPartialMatch(){
		return partialMatch;
	}

	public void setGeometry(Geometry geometry){
		this.geometry = geometry;
	}

	public Geometry getGeometry(){
		return geometry;
	}

	public void setAddressComponents(List<AddressComponentsItem> addressComponents){
		this.addressComponents = addressComponents;
	}

	public List<AddressComponentsItem> getAddressComponents(){
		return addressComponents;
	}

	public void setPlaceId(String placeId){
		this.placeId = placeId;
	}

	public String getPlaceId(){
		return placeId;
	}

	@Override
 	public String toString(){
		return 
			"ResultsItem{" + 
			"formatted_address = '" + formattedAddress + '\'' + 
			",types = '" + types + '\'' + 
			",partial_match = '" + partialMatch + '\'' + 
			",geometry = '" + geometry + '\'' + 
			",address_components = '" + addressComponents + '\'' + 
			",place_id = '" + placeId + '\'' + 
			"}";
		}
}