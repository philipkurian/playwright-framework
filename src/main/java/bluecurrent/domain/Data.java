package bluecurrent.domain;

import io.cucumber.core.internal.com.fasterxml.jackson.annotation.JsonProperty;

public class Data{
    @JsonProperty("CPU model")
    public String cPUmodel;
    @JsonProperty("Hard disk size")
    public String harddisksize;
    @JsonProperty("Strap Colour")
    public String strapColour;
    @JsonProperty("Case Size")
    public String caseSize;
    @JsonProperty("Color")
    public String color;
    @JsonProperty("Description")
    public String description;
    @JsonProperty("Capacity")
    public String capacity;
    @JsonProperty("Screen size")
    public double screensize;
    @JsonProperty("Generation")
    public String generation;
    @JsonProperty("Price")
    public String price;
}
