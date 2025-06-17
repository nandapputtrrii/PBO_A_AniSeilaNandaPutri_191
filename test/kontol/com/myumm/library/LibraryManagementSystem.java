package com.myumm.library;

import com.myumm.library.model.Book;
import com.myumm.library.model.BorrowRecord;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.BlendMode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.HBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.*;


public class LibraryManagementSystem extends Application {

    private BorderPane mainLayout;
    private VBox sideMenu;
    private StackPane contentArea;

    @Override
    public void start(Stage primaryStage) {
        setupUI();

        primaryStage.setTitle("Student Dashboard - myUMM Library");
        primaryStage.setScene(new Scene(mainLayout, 1200, 800));
        primaryStage.show();
    }

    private void setupUI() {
        mainLayout = new BorderPane();
        mainLayout.setStyle("-fx-background-color: #f0f0f0;");

        // Create header
        createHeader();

        // Create side menu
        createSideMenu();

        // Create content area
        createContentArea();

        // Set initial content to Profile
        showProfile();

        mainLayout.setTop(createHeader());
        mainLayout.setLeft(sideMenu);
        mainLayout.setCenter(contentArea);
    }

    private HBox createHeader() {
        HBox header = new HBox();
        header.setPadding(new Insets(15, 20, 15, 20));
        header.setAlignment(Pos.CENTER_LEFT);
        header.setStyle("-fx-background-color: #ffffff; -fx-border-color: #e0e0e0; -fx-border-width: 0 0 1 0;");

        Label title = new Label("Student Dashboard - myUMM Library");
        title.setFont(Font.font("System", FontWeight.BOLD, 16));
        title.setTextFill(Color.web("#333333"));

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        Button accountBtn = new Button("Account");
        accountBtn.setStyle("-fx-background-color: #f5f5f5; -fx-border-color: #ddd; -fx-padding: 8 15;");

        header.getChildren().addAll(title, spacer, accountBtn);
        return header;
    }

    private void createSideMenu() {
        sideMenu = new VBox();
        sideMenu.setPrefWidth(250);
        sideMenu.setStyle("-fx-background-color: #a8c5e0;");

        // Header section
        VBox headerSection = new VBox();
        headerSection.setPadding(new Insets(30, 20, 30, 20));
        headerSection.setAlignment(Pos.CENTER);
        headerSection.setStyle("-fx-background-color: #8bb3d9;");

        Label userLabel = new Label("L@ser");
        userLabel.setFont(Font.font("System", FontWeight.BOLD, 18));
        userLabel.setTextFill(Color.WHITE);

        Label libraryLabel = new Label("myUMM Library");
        libraryLabel.setFont(Font.font("System", 14));
        libraryLabel.setTextFill(Color.WHITE);

        headerSection.getChildren().addAll(userLabel, libraryLabel);

        // Menu items
        VBox menuItems = new VBox();
        menuItems.setSpacing(5);
        menuItems.setPadding(new Insets(20, 0, 0, 0));

        Button profileBtn = createMenuButton("Profile", true);
        Button borrowBtn = createMenuButton("Borrow Book", false);
        Button returnBtn = createMenuButton("Return Book", false);
        Button searchBtn = createMenuButton("Search Book", false);

        // Event handlers
        profileBtn.setOnAction(e -> {
            resetMenuButtons();
            profileBtn.setStyle(getActiveMenuStyle());
            showProfile();
        });

        borrowBtn.setOnAction(e -> {
            resetMenuButtons();
            borrowBtn.setStyle(getActiveMenuStyle());
            showBorrowBook();
        });

        returnBtn.setOnAction(e -> {
            resetMenuButtons();
            returnBtn.setStyle(getActiveMenuStyle());
            showReturnBook();
        });

        searchBtn.setOnAction(e -> {
            resetMenuButtons();
            searchBtn.setStyle(getActiveMenuStyle());
            showSearchBook();
        });

        menuItems.getChildren().addAll(profileBtn, borrowBtn, returnBtn, searchBtn);
        sideMenu.getChildren().addAll(headerSection, menuItems);
    }

    private Button createMenuButton(String text, boolean active) {
        Button btn = new Button(text);
        btn.setPrefWidth(250);
        btn.setPrefHeight(50);
        btn.setAlignment(Pos.CENTER_LEFT);
        btn.setPadding(new Insets(15, 20, 15, 30));
        btn.setFont(Font.font("System", 14));

        if (active) {
            btn.setStyle(getActiveMenuStyle());
        } else {
            btn.setStyle(getInactiveMenuStyle());
        }

        return btn;
    }

    private String getActiveMenuStyle() {
        return "-fx-background-color: #6b9bd1; -fx-text-fill: white; -fx-border-width: 0; " +
                "-fx-background-radius: 0; -fx-cursor: hand;";
    }

    private String getInactiveMenuStyle() {
        return "-fx-background-color: transparent; -fx-text-fill: white; -fx-border-width: 0; " +
                "-fx-background-radius: 0; -fx-cursor: hand;";
    }

    private void resetMenuButtons() {
        VBox menuItems = (VBox) sideMenu.getChildren().get(1); // indeks 1 = menuItems
        for (Node node : menuItems.getChildren()) {
            if (node instanceof Button) {
                node.setStyle(getInactiveMenuStyle());
            }
        }
    }


    private void createContentArea() {
        contentArea = new StackPane();
        contentArea.setPadding(new Insets(30));
        contentArea.setStyle("-fx-background-color: #ffffff;");
    }

    private void showProfile() {
        VBox profileContent = new VBox();
        profileContent.setSpacing(20);

        Label titleLabel = new Label("Profile");
        titleLabel.setFont(Font.font("System", FontWeight.BOLD, 24));
        titleLabel.setTextFill(Color.web("#333"));

        HBox profileSection = new HBox();
        profileSection.setSpacing(30);
        profileSection.setAlignment(Pos.TOP_LEFT);

        VBox leftSection = new VBox();
        leftSection.setSpacing(15);

        Label studentLabel = new Label("Data Mahasiswa");
        studentLabel.setFont(Font.font("System", FontWeight.BOLD, 18));

        // Profile circle placeholder
        Region profileCircle = new Region();
        profileCircle.setPrefSize(120, 120);
        profileCircle.setStyle("-fx-background-color: #cccccc; -fx-background-radius: 60;");

        Button editBtn = new Button("Edit Profile");
        editBtn.setStyle("-fx-background-color: #5a9fd4; -fx-text-fill: white; -fx-padding: 8 20;");

        leftSection.getChildren().addAll(studentLabel, profileCircle, editBtn);

        VBox rightSection = new VBox();
        rightSection.setSpacing(10);

        Label indexLabel = new Label("Index Peminjaman Buku");
        indexLabel.setFont(Font.font("System", FontWeight.BOLD, 16));

        Region indexArea = new Region();
        indexArea.setPrefSize(300, 200);
        indexArea.setStyle("-fx-background-color: #f5f5f5; -fx-border-color: #ddd;");

        rightSection.getChildren().addAll(indexLabel, indexArea);

        profileSection.getChildren().addAll(leftSection, rightSection);
        profileContent.getChildren().addAll(titleLabel, profileSection);

        contentArea.getChildren().clear();
        contentArea.getChildren().add(profileContent);
    }

    private void showBorrowBook() {
        VBox borrowContent = new VBox();
        borrowContent.setSpacing(20);

        Label titleLabel = new Label("Borrow Book");
        titleLabel.setFont(Font.font("System", FontWeight.BOLD, 24));
        titleLabel.setTextFill(Color.web("#333"));

        // Search section
        HBox searchSection = new HBox();
        searchSection.setSpacing(10);
        searchSection.setAlignment(Pos.CENTER_LEFT);

        Label searchLabel = new Label("Search Book:");
        searchLabel.setFont(Font.font("System", FontWeight.BOLD, 14));

        TextField searchField = new TextField();
        searchField.setPromptText("Enter book title, author, or ID...");
        searchField.setPrefWidth(300);

        Button searchBtn = new Button("Search");
        searchBtn.setStyle("-fx-background-color: #5a9fd4; -fx-text-fill: white; -fx-padding: 8 20;");

        searchSection.getChildren().addAll(searchLabel, searchField, searchBtn);

        // Available books table
        TableView<Book> booksTable = new TableView<>();
        booksTable.setPrefHeight(400);

        TableColumn<Book, String> idCol = new TableColumn<>("Book ID");
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        idCol.setPrefWidth(100);

        TableColumn<Book, String> titleCol = new TableColumn<>("Title");
        titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        titleCol.setPrefWidth(250);

        TableColumn<Book, String> authorCol = new TableColumn<>("Author");
        authorCol.setCellValueFactory(new PropertyValueFactory<>("author"));
        authorCol.setPrefWidth(200);

        TableColumn<Book, String> categoryCol = new TableColumn<>("Category");
        categoryCol.setCellValueFactory(new PropertyValueFactory<>("category"));
        categoryCol.setPrefWidth(150);

        TableColumn<Book, String> statusCol = new TableColumn<>("Status");
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));
        statusCol.setPrefWidth(100);

        TableColumn<Book, Void> actionCol = new TableColumn<>("Action");
        actionCol.setPrefWidth(100);
        actionCol.setCellFactory(param -> new TableCell<Book, Void>() {
            private final Button borrowBtn = new Button("Borrow");

            {
                borrowBtn.setStyle("-fx-background-color: #28a745; -fx-text-fill: white; -fx-padding: 5 15;");
                borrowBtn.setOnAction(event -> {
                    Book book = getTableView().getItems().get(getIndex());
                    if ("Available".equals(book.getStatus())) {
                        showAlert("Success", "Book '" + book.getTitle() + "' has been borrowed successfully!");
                    } else {
                        showAlert("Error", "This book is not available for borrowing.");
                    }
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    Book book = getTableView().getItems().get(getIndex());
                    borrowBtn.setDisable(!"Available".equals(book.getStatus()));
                    setGraphic(borrowBtn);
                }
            }
        });

        booksTable.getColumns().addAll(idCol, titleCol, authorCol, categoryCol, statusCol, actionCol);

        // Sample data
        ObservableList<Book> books = FXCollections.observableArrayList(
                new Book("B001", "Java Programming Fundamentals", "John Smith", "Programming", "Available"),
                new Book("B002", "Data Structures and Algorithms", "Jane Doe", "Computer Science", "Borrowed"),
                new Book("B003", "Database Management Systems", "Robert Johnson", "Database", "Available"),
                new Book("B004", "Web Development with Spring", "Alice Brown", "Web Development", "Available"),
                new Book("B005", "Machine Learning Basics", "David Wilson", "AI/ML", "Available")
        );

        booksTable.setItems(books);

        borrowContent.getChildren().addAll(titleLabel, searchSection, new Label("Available Books:"), booksTable);

        contentArea.getChildren().clear();
        contentArea.getChildren().add(borrowContent);
    }

    private void showReturnBook() {
        VBox returnContent = new VBox();
        returnContent.setSpacing(20);

        Label titleLabel = new Label("Return Book");
        titleLabel.setFont(Font.font("System", FontWeight.BOLD, 24));
        titleLabel.setTextFill(Color.web("#333"));

        // Search section
        HBox searchSection = new HBox();
        searchSection.setSpacing(10);
        searchSection.setAlignment(Pos.CENTER_LEFT);

        Label searchLabel = new Label("Search Borrowed Book:");
        searchLabel.setFont(Font.font("System", FontWeight.BOLD, 14));

        TextField searchField = new TextField();
        searchField.setPromptText("Enter book ID or title...");
        searchField.setPrefWidth(300);

        Button searchBtn = new Button("Search");
        searchBtn.setStyle("-fx-background-color: #5a9fd4; -fx-text-fill: white; -fx-padding: 8 20;");

        searchSection.getChildren().addAll(searchLabel, searchField, searchBtn);

        // Borrowed books table
        TableView<BorrowRecord> borrowedTable = new TableView<>();
        borrowedTable.setPrefHeight(400);

        TableColumn<BorrowRecord, String> bookIdCol = new TableColumn<>("Book ID");
        bookIdCol.setCellValueFactory(new PropertyValueFactory<>("bookId"));
        bookIdCol.setPrefWidth(100);

        TableColumn<BorrowRecord, String> titleCol = new TableColumn<>("Book Title");
        titleCol.setCellValueFactory(new PropertyValueFactory<>("bookTitle"));
        titleCol.setPrefWidth(250);

        TableColumn<BorrowRecord, String> borrowDateCol = new TableColumn<>("Borrow Date");
        borrowDateCol.setCellValueFactory(new PropertyValueFactory<>("borrowDate"));
        borrowDateCol.setPrefWidth(120);

        TableColumn<BorrowRecord, String> dueDateCol = new TableColumn<>("Due Date");
        dueDateCol.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
        dueDateCol.setPrefWidth(120);

        TableColumn<BorrowRecord, String> statusCol = new TableColumn<>("Status");
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));
        statusCol.setPrefWidth(100);

        TableColumn<BorrowRecord, Void> actionCol = new TableColumn<>("Action");
        actionCol.setPrefWidth(100);
        actionCol.setCellFactory(param -> new TableCell<BorrowRecord, Void>() {
            private final Button returnBtn = new Button("Return");

            {
                returnBtn.setStyle("-fx-background-color: #dc3545; -fx-text-fill: white; -fx-padding: 5 15;");
                returnBtn.setOnAction(event -> {
                    BorrowRecord record = getTableView().getItems().get(getIndex());
                    showAlert("Success", "Book '" + record.getBookTitle() + "' has been returned successfully!");
                    getTableView().getItems().remove(record);
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(returnBtn);
                }
            }
        });

        borrowedTable.getColumns().addAll(bookIdCol, titleCol, borrowDateCol, dueDateCol, statusCol, actionCol);

        // Sample borrowed books data
        ObservableList<BorrowRecord> borrowedBooks = FXCollections.observableArrayList(
                new BorrowRecord("B001", "Java Programming Fundamentals", "2025-06-10", "2025-06-24", "Active"),
                new BorrowRecord("B003", "Database Management Systems", "2025-06-12", "2025-06-26", "Active"),
                new BorrowRecord("B007", "Software Engineering Principles", "2025-06-08", "2025-06-22", "Overdue")
        );

        borrowedTable.setItems(borrowedBooks);

        returnContent.getChildren().addAll(titleLabel, searchSection, new Label("Your Borrowed Books:"), borrowedTable);

        contentArea.getChildren().clear();
        contentArea.getChildren().add(returnContent);
    }

    private void showSearchBook() {
        VBox searchContent = new VBox();
        searchContent.setSpacing(20);

        Label titleLabel = new Label("Search Book");
        titleLabel.setFont(Font.font("System", FontWeight.BOLD, 24));
        titleLabel.setTextFill(Color.web("#333"));

        // Advanced search section
        VBox searchSection = new VBox();
        searchSection.setSpacing(15);
        searchSection.setPadding(new Insets(20));
        searchSection.setStyle("-fx-background-color: #f8f9fa; -fx-border-color: #dee2e6; -fx-border-radius: 5;");

        Label searchTitle = new Label("Advanced Search");
        searchTitle.setFont(Font.font("System", FontWeight.BOLD, 16));

        GridPane searchGrid = new GridPane();
        searchGrid.setHgap(15);
        searchGrid.setVgap(10);

        // Search fields
        Label titleSearchLabel = new Label("Title:");
        TextField titleField = new TextField();
        titleField.setPromptText("Enter book title...");

        Label authorSearchLabel = new Label("Author:");
        TextField authorField = new TextField();
        authorField.setPromptText("Enter author name...");

        Label categorySearchLabel = new Label("Category:");
        ComboBox<String> categoryCombo = new ComboBox<>();
        categoryCombo.getItems().addAll("All Categories", "Programming", "Computer Science", "Database",
                "Web Development", "AI/ML", "Software Engineering");
        categoryCombo.setValue("All Categories");

        Label statusSearchLabel = new Label("Status:");
        ComboBox<String> statusCombo = new ComboBox<>();
        statusCombo.getItems().addAll("All Status", "Available", "Borrowed");
        statusCombo.setValue("All Status");

        searchGrid.add(titleSearchLabel, 0, 0);
        searchGrid.add(titleField, 1, 0);
        searchGrid.add(authorSearchLabel, 2, 0);
        searchGrid.add(authorField, 3, 0);
        searchGrid.add(categorySearchLabel, 0, 1);
        searchGrid.add(categoryCombo, 1, 1);
        searchGrid.add(statusSearchLabel, 2, 1);
        searchGrid.add(statusCombo, 3, 1);

        HBox buttonSection = new HBox();
        buttonSection.setSpacing(10);
        buttonSection.setAlignment(Pos.CENTER_LEFT);

        Button searchBtn = new Button("Search");
        searchBtn.setStyle("-fx-background-color: #007bff; -fx-text-fill: white; -fx-padding: 8 20;");

        Button clearBtn = new Button("Clear");
        clearBtn.setStyle("-fx-background-color: #6c757d; -fx-text-fill: white; -fx-padding: 8 20;");
        clearBtn.setOnAction(e -> {
            titleField.clear();
            authorField.clear();
            categoryCombo.setValue("All Categories");
            statusCombo.setValue("All Status");
        });

        buttonSection.getChildren().addAll(searchBtn, clearBtn);

        searchSection.getChildren().addAll(searchTitle, searchGrid, buttonSection);

        // Results table
        Label resultsLabel = new Label("Search Results:");
        resultsLabel.setFont(Font.font("System", FontWeight.BOLD, 16));

        TableView<Book> resultsTable = new TableView<>();
        resultsTable.setPrefHeight(350);

        TableColumn<Book, String> idCol = new TableColumn<>("ID");
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        idCol.setPrefWidth(80);

        TableColumn<Book, String> titleCol = new TableColumn<>("Title");
        titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        titleCol.setPrefWidth(280);

        TableColumn<Book, String> authorCol = new TableColumn<>("Author");
        authorCol.setCellValueFactory(new PropertyValueFactory<>("author"));
        authorCol.setPrefWidth(180);

        TableColumn<Book, String> categoryCol = new TableColumn<>("Category");
        categoryCol.setCellValueFactory(new PropertyValueFactory<>("category"));
        categoryCol.setPrefWidth(150);

        TableColumn<Book, String> statusCol = new TableColumn<>("Status");
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));
        statusCol.setPrefWidth(100);

        TableColumn<Book, Void> actionCol = new TableColumn<>("Action");
        actionCol.setPrefWidth(120);
        actionCol.setCellFactory(param -> new TableCell<Book, Void>() {
            private final HBox actionBox = new HBox(5);
            private final Button viewBtn = new Button("View");
            private final Button borrowBtn = new Button("Borrow");

            {
                viewBtn.setStyle("-fx-background-color: #17a2b8; -fx-text-fill: white; -fx-padding: 3 8; -fx-font-size: 10;");
                borrowBtn.setStyle("-fx-background-color: #28a745; -fx-text-fill: white; -fx-padding: 3 8; -fx-font-size: 10;");

                viewBtn.setOnAction(event -> {
                    Book book = getTableView().getItems().get(getIndex());
                    showAlert("Book Details", "Title: " + book.getTitle() + "\nAuthor: " + book.getAuthor() +
                            "\nCategory: " + book.getCategory() + "\nStatus: " + book.getStatus());
                });

                borrowBtn.setOnAction(event -> {
                    Book book = getTableView().getItems().get(getIndex());
                    if ("Available".equals(book.getStatus())) {
                        showAlert("Success", "Book '" + book.getTitle() + "' has been borrowed successfully!");
                    } else {
                        showAlert("Error", "This book is not available for borrowing.");
                    }
                });

                actionBox.getChildren().addAll(viewBtn, borrowBtn);
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    Book book = getTableView().getItems().get(getIndex());
                    borrowBtn.setDisable(!"Available".equals(book.getStatus()));
                    setGraphic(actionBox);
                }
            }
        });

        resultsTable.getColumns().addAll(idCol, titleCol, authorCol, categoryCol, statusCol, actionCol);

        // Sample search results
        ObservableList<Book> allBooks = FXCollections.observableArrayList(
                new Book("B001", "Java Programming Fundamentals", "John Smith", "Programming", "Available"),
                new Book("B002", "Data Structures and Algorithms", "Jane Doe", "Computer Science", "Borrowed"),
                new Book("B003", "Database Management Systems", "Robert Johnson", "Database", "Available"),
                new Book("B004", "Web Development with Spring", "Alice Brown", "Web Development", "Available"),
                new Book("B005", "Machine Learning Basics", "David Wilson", "AI/ML", "Available"),
                new Book("B006", "Advanced Java Concepts", "Michael Chen", "Programming", "Borrowed"),
                new Book("B007", "Software Engineering Principles", "Sarah Davis", "Software Engineering", "Available"),
                new Book("B008", "MySQL Database Design", "Tom Anderson", "Database", "Available")
        );

        resultsTable.setItems(allBooks);

        searchContent.getChildren().addAll(titleLabel, searchSection, resultsLabel, resultsTable);

        contentArea.getChildren().clear();
        contentArea.getChildren().add(searchContent);
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}