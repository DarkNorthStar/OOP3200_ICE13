module ca.durhamcollege.oop3200_ice13_tyler {
    requires javafx.controls;
    requires javafx.fxml;


    opens ca.durhamcollege.oop3200_ice13_tyler to javafx.fxml;
    exports ca.durhamcollege.oop3200_ice13_tyler;
}