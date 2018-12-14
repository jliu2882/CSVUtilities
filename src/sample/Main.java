package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import java.io.File;
import java.util.List;

public class Main extends Application {
    final static String Brooklyn = "Brooklyn";
    final static String Queens = "Queens";
    final static String Manhattan = "Manhattan";
    final static String Bronx = "Bronx";
    final static String StatenIsland = "Staten Island";
    @Override public void start(Stage stage) {
        CSVUtilities data = new CSVUtilities(new File("src/RodentInspection.csv"));
        List<String> rodent = data.getDataString(15);
        int b = 0;
        int q = 0;
        int m = 0;
        int bx = 0;
        int s = 0;
        for(int i = 0; i <rodent.size(); i++){
            if(rodent.get(i).equals("Brooklyn")){
                b++;
            } else if(rodent.get(i).equals("Queens")){
                q++;
            } else if(rodent.get(i).equals("Manhattan")){
                m++;
            } else if(rodent.get(i).equals("Bronx")){
                bx++;
            } else if(rodent.get(i).equals("Staten Island")){
                s++;
            }
            else{
                System.out.println("error");
            }

        }
        stage.setTitle("Bar Chart Sample");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String,Number> bc =
                new BarChart<String,Number>(xAxis,yAxis);
        bc.setTitle("Rodent Inspection by Borough");
        xAxis.setLabel("Borough");
        yAxis.setLabel("Amount of Inspections");

        XYChart.Series series1 = new XYChart.Series();
        series1.setName("2003");
        series1.getData().add(new XYChart.Data(Brooklyn, b));
        series1.getData().add(new XYChart.Data(Queens, q));
        series1.getData().add(new XYChart.Data(Manhattan, m));
        series1.getData().add(new XYChart.Data(Bronx, bx));
        series1.getData().add(new XYChart.Data(StatenIsland, s));

        /**XYChart.Series series2 = new XYChart.Series();
        series2.setName("2004");
        series2.getData().add(new XYChart.Data(Brooklyn, 57401.85));
        series2.getData().add(new XYChart.Data(Queens, 41941.19));
        series2.getData().add(new XYChart.Data(Manhattan, 45263.37));
        series2.getData().add(new XYChart.Data(Bronx, 117320.16));
        series2.getData().add(new XYChart.Data(StatenIsland, 14845.27));

        XYChart.Series series3 = new XYChart.Series();
        series3.setName("2005");
        series3.getData().add(new XYChart.Data(Brooklyn, 45000.65));
        series3.getData().add(new XYChart.Data(Queens, 44835.76));
        series3.getData().add(new XYChart.Data(Manhattan, 18722.18));
        series3.getData().add(new XYChart.Data(Bronx, 17557.31));
        series3.getData().add(new XYChart.Data(StatenIsland, 92633.68));
        */

        Scene scene  = new Scene(bc,800,600);
        bc.getData().addAll(series1);
        //bc.getData().addAll(series1,series2,series3);
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
