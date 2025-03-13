package bluecurrent.domain;

import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;


public class Root implements IBlueCurrentDomain {
    public ArrayList<TestDatum> testData;

    @Override
    public void Defaults() {
        testData = new ArrayList<TestDatum>();
        TestDatum temp = new TestDatum();
        temp.id = "1";
        temp.name = "Apple MacBook Pro 16";
        temp.createdAt = null;
        temp.data = new Data();
        temp.data.caseSize = "";
        temp.data.color = "Cloudy White";
        temp.data.cPUmodel = "Intel Core i9";
        temp.data.harddisksize = "1 TB";
        temp.data.price = "1849.99";
        temp.data.strapColour = "";
        temp.data.description = "";
        temp.data.capacity = "";
        temp.data.screensize = 0;
        temp.data.generation = "";
        testData.add(temp);
    }

    @Override
    public String SpecialPostProcessing(String arg0) {
        StringBuilder result = new StringBuilder();
        result.append("{ \"Root\" : ")
                .append(arg0)
                .append("}");
        return result.toString();
    }

    @Override
    public String Serialize() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(this);
    }

    @Override
    public String SpecialPreProcessing(String arg0) {
        String result = "";
        String[] Split1 = arg0.split("\\[", 2);
        String[] Split2 = Split1[1].split("\\]");
        result = Split2[0];
        return result;
    }


}
