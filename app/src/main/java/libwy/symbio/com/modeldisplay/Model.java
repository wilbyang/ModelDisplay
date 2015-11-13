package libwy.symbio.com.modeldisplay;

import java.util.ArrayList;

/**
 * Created by wilbyang on 13/11/15.
 */
import java.util.ArrayList;

public class Model {
    private String name, firstImageUrl, hairColor, eyeColor;
    private double height;

    public Model() {
    }

    public Model(String name, String firstImageUrl, String hairColor, String eyeColor, double height) {
        this.name = name;
        this.firstImageUrl = firstImageUrl;
        this.hairColor = hairColor;
        this.eyeColor = eyeColor;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstImageUrl() {
        return firstImageUrl;
    }

    public void setFirstImageUrl(String firstImageUrl) {
        this.firstImageUrl = firstImageUrl;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}

