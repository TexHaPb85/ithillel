package edu.ithillel._common.food;

import edu.ithillel.reflection.annotations.Hillel;

@Hillel
public class Banana extends Fruit {
    @Hillel(annotationParam1 = "two")
    public String bananaExpDate;

    @Hillel
    public String getBananaExpDate() {
        return bananaExpDate;
    }

    public void setBananaExpDate(String bananaExpDate) {
        this.bananaExpDate = bananaExpDate;
    }
}
