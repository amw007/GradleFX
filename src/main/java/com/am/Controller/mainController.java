package com.am.Controller;

import com.am.Main;
import com.am.Model.Fruit;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class mainController implements Initializable {

    @FXML
    private VBox chooseFruitcard;

    @FXML
    private Label chooseNamelabel;

    @FXML
    private Label choosePricelabel;

    @FXML
    private ImageView fruitimg;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private GridPane grid;

    private List<Fruit> fruits = new ArrayList<>();
    private Image img;
    private MyListener myListener;
        private List<Fruit> getFruits(){
        List<Fruit> fruits = new ArrayList<>();
        Fruit fruit;

            fruit = new Fruit();
            fruit.setName("Kiwi");
            fruit.setPrice(2.99);
            fruit.setColor("6A7324");
            fruit.setImgSrc("/com/am/img/kiwi.png");
            fruits.add(fruit);

            fruit = new Fruit();
            fruit.setName("Coconut");
            fruit.setPrice(1.99);
            fruit.setColor("A77458");
            fruit.setImgSrc("/com/am/img/icon.png");
            fruits.add(fruit);

            fruit = new Fruit();
            fruit.setName("peach");
            fruit.setPrice(3.99);
            fruit.setColor("F16C31");
            fruit.setImgSrc("/com/am/img/kiwi.png");
            fruits.add(fruit);

            fruit = new Fruit();
            fruit.setName("Grapes");
            fruit.setPrice(2.09);
            fruit.setColor("291036");
            fruit.setImgSrc("/com/am/img/kiwi.png");
            fruits.add(fruit);

            fruit = new Fruit();
            fruit.setName("Watermelon");
            fruit.setPrice(2.09);
            fruit.setColor("223710");
            fruit.setImgSrc("/com/am/img/kiwi.png");
            fruits.add(fruit);

            fruit = new Fruit();
            fruit.setName("Orange");
            fruit.setPrice(2.99);
            fruit.setColor("80080c");
            fruit.setImgSrc("/com/am/img/kiwi.png");
            fruits.add(fruit);

            fruit = new Fruit();
            fruit.setName("Mango");
            fruit.setPrice(2.99);
            fruit.setColor("FFB685");
            fruit.setImgSrc("/com/am/img/kiwi.png");
            fruits.add(fruit);

            fruit = new Fruit();
            fruit.setName("Cherry");
            fruit.setPrice(2.99);
            fruit.setColor("5F060E");
            fruit.setImgSrc("/com/am/img/kiwi.png");
            fruits.add(fruit);

            fruit = new Fruit();
            fruit.setName("Banana");
            fruit.setPrice(2.99);
            fruit.setColor("E7C00F");
            fruit.setImgSrc("/com/am/img/kiwi.png");
            fruits.add(fruit);

            fruit = new Fruit();
            fruit.setName("Kiwi");
            fruit.setPrice(2.99);
            fruit.setColor("6A7324");
            fruit.setImgSrc("/com/am/img/kiwi.png");
            fruits.add(fruit);

        return fruits;
    }

    private void setChooseFruit(Fruit f){
        chooseNamelabel.setText(f.getName());
        choosePricelabel.setText(Main.currency+f.getPrice());
        img = new Image(Objects.requireNonNull(getClass().getResourceAsStream(f.getImgSrc())));
        fruitimg.setImage(img);
        chooseFruitcard.setStyle("-fx-background-color: #"+f.getColor()+";\n"+
                "-fx-background-radius: 30;");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fruits.addAll(getFruits());
        if (fruits.size()>0) {
            setChooseFruit(fruits.get(0));
            myListener = new MyListener() {
                @Override
                public void onFruitClickListener(Fruit fruit) {
                    setChooseFruit(fruit);
                }

            };
        }        int coloumn = 0,row=0;

        try {
            for (int i = 0; i < fruits.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/com/am/view/items.fxml"));
                AnchorPane anchorPane=fxmlLoader.load();

                ItemController itemController = fxmlLoader.getController();
                itemController.setFruit(fruits.get(i),myListener);

                if (coloumn==3){
                    coloumn = 0;
                    row++;
                }

                grid.add(anchorPane,coloumn++,row);

                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane,new Insets(10));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
