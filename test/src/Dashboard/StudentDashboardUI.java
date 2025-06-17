package Dashboard;

import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.scene.Node;

// import java.sql.*; // Boleh dikomentari jika tidak ada koneksi DB sama sekali
// import Database.DatabaseConnection; // DIKOMENTARI
// import Model.Member; // DIKOMENTARI
// import MenuMHS.Borrow; // DIKOMENTARI

public class StudentDashboardUI extends Application {
    // public Member member; // DIKOMENTARI
    private BorderPane root;

    // Constructor to accept member data (DIKOMENTARI)
    // public StudentDashboardUI(Member member) {
    //     this.member = member;
    // }

    // DITAMBAHKAN: Constructor default agar class bisa di-launch secara independen
    public StudentDashboardUI() {

    }

    @Override
    public void start(Stage primaryStage) {
        // Sidebar
        VBox sidebar = new VBox(20);
        sidebar.setPadding(new Insets(0, 0, 0, 0));
        sidebar.setPrefWidth(220);
        sidebar.setStyle("-fx-background-color: #7ea6c7;");

        // Logo
        VBox logoBox = new VBox();
        logoBox.setAlignment(Pos.CENTER);
        logoBox.setPadding(new Insets(30, 0, 30, 0));
        Label logo1 = new Label("L@ser");
        logo1.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        logo1.setTextFill(Color.WHITE);
        Label logo2 = new Label("myUMM Library");
        logo2.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        logo2.setTextFill(Color.WHITE);
        logoBox.getChildren().addAll(logo1, logo2);

        // Menu
        VBox menuBox = new VBox(0);
        menuBox.setPadding(new Insets(0, 0, 0, 0));
        String[] menus = {"Profile", "Borrow Book", "Return Book", "Search Book"};
        for (String m : menus) {
            Button btn = new Button(m);
            btn.setPrefWidth(220);
            btn.setAlignment(Pos.CENTER_LEFT);
            btn.setPadding(new Insets(18, 30, 18, 30));
            btn.setStyle("-fx-background-color: transparent; -fx-text-fill: white; -fx-font-size: 16px; -fx-border-width: 0 0 1 0; -fx-border-color: #bcd2e8;");
            btn.setOnMouseEntered(e -> btn.setStyle("-fx-background-color: #a2c3de; -fx-text-fill: #2c3e50; -fx-font-size: 16px; -fx-border-width: 0 0 1 0; -fx-border-color: #bcd2e8;"));
            btn.setOnMouseExited(e -> btn.setStyle("-fx-background-color: transparent; -fx-text-fill: white; -fx-font-size: 16px; -fx-border-width: 0 0 1 0; -fx-border-color: #bcd2e8;"));

            if (m.equals("Profile")) {
                btn.setOnAction(e -> showProfileContent(primaryStage));
            } else if (m.equals("Borrow Book")) {
                btn.setOnAction(e -> showBorrowedBooksContent(primaryStage));
            } else if (m.equals("Return Book")) {
                btn.setOnAction(e -> showReturnBookContent(primaryStage));
            } else if (m.equals("Search Book")) {
                btn.setOnAction(e -> showSearchBookContent(primaryStage));
            }

            menuBox.getChildren().add(btn);
        }
        sidebar.getChildren().addAll(logoBox, menuBox);

        // Header
        HBox header = new HBox();
        header.setStyle("-fx-background-color: #e5e5e5;");
        header.setPadding(new Insets(0, 30, 0, 0));
        header.setPrefHeight(60);
        Region headerSpacer = new Region();
        HBox.setHgrow(headerSpacer, Priority.ALWAYS);

        // DIMODIFIKASI: Menggunakan data dummy karena 'member' tidak ada
        String accountName = "Student"; // Data dummy
        Label accountLabel = new Label(accountName);
        accountLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 16));
        accountLabel.setTextFill(Color.web("#888"));

        Circle accountCircle = new Circle(18, Color.LIGHTGRAY);

        // DIMODIFIKASI: Menggunakan data dummy
        String accountInitialText = "S"; // Data dummy
        Label accountInitial = new Label(accountInitialText);
        accountInitial.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        accountInitial.setTextFill(Color.web("#888"));

        StackPane accountPane = new StackPane(accountCircle, accountInitial);

        // STUDENT SEJAJAR SAMA FOTO PROFIL HEADER
        HBox accountBox = new HBox(8); // TAMBAHAN
        accountBox.setAlignment(Pos.CENTER); // TAMBAHAN
        accountBox.getChildren().addAll(accountPane, accountLabel);
        header.setAlignment(Pos.CENTER_RIGHT); //TAMBAHAN
        header.getChildren().addAll(headerSpacer, accountPane, new Label("  "), accountLabel);

        // Main Content - Default Profile Content
        VBox mainContent = createProfileContent(true);

        // Footer
        HBox footer = new HBox();
        footer.setAlignment(Pos.CENTER);
        footer.setPrefHeight(30);
        footer.setStyle("-fx-background-color: #e5e5e5;");
        Label footerLabel = new Label("Jalan Raya Tlogomas No. 246, Jatimulyo, Lowokwaru, Malang, Jawa Timur, 65144");
        footerLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 12));
        footerLabel.setTextFill(Color.web("#b0b0b0"));
        footer.getChildren().add(footerLabel);

        BorderPane rootPane = new BorderPane();
        rootPane.setLeft(sidebar);
        rootPane.setTop(header);
        rootPane.setCenter(mainContent);
        rootPane.setBottom(footer);

        StackPane root = new StackPane();
        root.getChildren().add(rootPane);

        Scene scene = new Scene(root, 1200, 800);
        primaryStage.setTitle("Student Dashboard - myUMM Library");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private VBox createProfileContent(boolean isEditing) {
        VBox mainContent = new VBox(18);
        mainContent.setPadding(new Insets(30, 0, 0, 0));
        mainContent.setStyle("-fx-background-color: transparent;");

        VBox profilePanel = new VBox(0);
        profilePanel.setPadding(new Insets(0));
        profilePanel.setAlignment(Pos.TOP_CENTER);

        VBox whitePanel = new VBox(18);
        whitePanel.setPadding(new Insets(30));
        whitePanel.setAlignment(Pos.TOP_LEFT);
        whitePanel.setStyle("-fx-background-color: #fff; -fx-background-radius: 10;");

        Label profileTitle = new Label("Profile");
        profileTitle.setFont(Font.font("Arial", FontWeight.BOLD, 22));
        profileTitle.setTextFill(Color.web("#888"));
        profileTitle.setPadding(new Insets(0, 0, 18, 0));

        HBox dataRow = new HBox(30);
        dataRow.setAlignment(Pos.CENTER_LEFT);

        // Photo panel
        StackPane photoPane = new StackPane();
        Circle photoCircle = new Circle(70, Color.LIGHTGRAY);
        Label initial = new Label("S"); // Dummy Initial
        initial.setFont(Font.font("Arial", FontWeight.BOLD, 48));
        initial.setTextFill(Color.web("#888"));
        photoPane.getChildren().addAll(photoCircle, initial);

        // Text data panel
        VBox dataText = new VBox(10);

        if (!isEditing) {
            // Tampilan biasa
            Label name = new Label("Student Name");
            name.setFont(Font.font("Arial", FontWeight.BOLD, 18));
            name.setTextFill(Color.web("#222"));

            Label fakultas = new Label("Fakultas Ilmu Komputer");
            fakultas.setFont(Font.font("Arial", 14));
            fakultas.setTextFill(Color.web("#444"));

            Label prodi = new Label("Teknik Informatika");
            prodi.setFont(Font.font("Arial", 14));
            prodi.setTextFill(Color.web("#444"));

            Label hp = new Label("HP : 081234567890");
            hp.setFont(Font.font("Arial", 14));
            hp.setTextFill(Color.web("#444"));

            Label email = new Label("student@email.com");
            email.setFont(Font.font("Arial", 14));
            email.setTextFill(Color.web("#444"));

            Button editProfileBtn = new Button("Edit Profile");
            editProfileBtn.setStyle("-fx-background-color: #b8cfe5; -fx-text-fill: #444; -fx-font-size: 13px; -fx-background-radius: 8;");
            editProfileBtn.setPadding(new Insets(4, 12, 4, 12));
            editProfileBtn.setOnAction(e -> {
                Node newContent = createProfileContent(true);
                root.setCenter(newContent); // Pastikan root adalah BorderPane
            });

            dataText.getChildren().addAll(name, fakultas, prodi, hp, email, editProfileBtn);
        } else {
            // Tampilan edit
            TextField nameField = new TextField("Student Name");
            TextField fakultasField = new TextField("Fakultas Ilmu Komputer");
            TextField prodiField = new TextField("Teknik Informatika");
            TextField hpField = new TextField("081234567890");
            TextField emailField = new TextField("student@email.com");

            Button simpanBtn = new Button("Simpan");
            simpanBtn.setStyle("-fx-background-color: #99c47b; -fx-text-fill: white; -fx-background-radius: 8;");
            simpanBtn.setOnAction(e -> {
                Node newContent = createProfileContent(false);
                root.setCenter(newContent);
            });

            dataText.getChildren().addAll(nameField, fakultasField, prodiField, hpField, emailField, simpanBtn);
        }

        // Index Peminjaman Panel
        VBox indexPanel = new VBox(10);
        indexPanel.setAlignment(Pos.TOP_CENTER);
        indexPanel.setPrefSize(220, 180);
        indexPanel.setStyle("-fx-background-color: #f2f2f2; -fx-background-radius: 7; -fx-border-radius: 7; -fx-border-color: #cccccc; -fx-border-width: 1;");
        Label indexLabel = new Label("Index Peminjaman Buku");
        indexLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        indexLabel.setTextFill(Color.web("#b0b0b0"));
        indexPanel.getChildren().add(indexLabel);

        // Tambahkan ke dataRow
        dataRow.getChildren().addAll(photoPane, dataText, indexPanel);

        VBox dataPanel = new VBox();
        dataPanel.setStyle("-fx-background-color: #f7f7f7; -fx-background-radius: 7; -fx-border-radius: 7; -fx-border-color: #e3e3e3; -fx-border-width: 1;");
        dataPanel.setPadding(new Insets(18));
        dataPanel.getChildren().addAll(dataRow);

        whitePanel.getChildren().addAll(profileTitle, dataPanel);
        profilePanel.getChildren().add(whitePanel);
        mainContent.getChildren().add(profilePanel);

        return mainContent;
    }

    private VBox createDataViewPanel(VBox[] dataPanelWrapper, HBox contentBox) {
        VBox dataPanel = new VBox(18);
        dataPanel.setPadding(new Insets(20));
        dataPanel.setStyle("-fx-background-color: #f7f7f7; -fx-background-radius: 7; -fx-border-color: #e3e3e3; -fx-border-width: 1;");
        dataPanel.setAlignment(Pos.TOP_LEFT);

        Label dataTitle = new Label("Data Mahasiswa");
        dataTitle.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        dataTitle.setTextFill(Color.web("#b0b0b0"));

        HBox dataRow = new HBox(30);
        dataRow.setAlignment(Pos.CENTER_LEFT);

        // Foto profil dummy
        StackPane photoPane = new StackPane();
        Circle photoCircle = new Circle(70, Color.LIGHTGRAY);
        Label initial = new Label("S");
        initial.setFont(Font.font("Arial", FontWeight.BOLD, 48));
        initial.setTextFill(Color.web("#888"));
        photoPane.getChildren().addAll(photoCircle, initial);

        VBox dataText = new VBox(4);
        dataText.getChildren().addAll(
                new Label("Student Name"),
                new Label("Fakultas Ilmu Komputer"),
                new Label("Teknik Informatika"),
                new Label("HP : 081234567890"),
                new Label("student@email.com")
        );
        for (Node label : dataText.getChildren()) {
            ((Label) label).setFont(Font.font("Arial", 14));
            ((Label) label).setTextFill(Color.web("#444"));
        }

        Button editBtn = new Button("Edit Profile");
        editBtn.setStyle("-fx-background-color: #b8cfe5; -fx-text-fill: #444; -fx-font-size: 13px; -fx-background-radius: 8;");
        editBtn.setPadding(new Insets(4, 12, 4, 12));

        editBtn.setOnAction(e -> {
            VBox newPanel = createDataEditPanel(dataPanelWrapper, contentBox);
            contentBox.getChildren().set(0, newPanel);
            dataPanelWrapper[0] = newPanel;
        });

        dataText.getChildren().add(editBtn);

        dataRow.getChildren().addAll(photoPane, dataText);
        dataPanel.getChildren().addAll(dataTitle, dataRow);
        return dataPanel;
    }

    private VBox createIndexPanel() {
        VBox indexPanel = new VBox();
        indexPanel.setAlignment(Pos.TOP_CENTER);
        indexPanel.setPrefSize(220, 180);
        indexPanel.setStyle("-fx-background-color: #e3e3e3; -fx-background-radius: 7; -fx-border-radius: 7; -fx-border-color: #cccccc; -fx-border-width: 1;");

        Label indexLabel = new Label("Index Peminjaman Buku");
        indexLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        indexLabel.setTextFill(Color.web("#b0b0b0"));

        indexPanel.getChildren().add(indexLabel);
        return indexPanel;
    }

    private VBox createDataEditPanel(VBox[] dataPanelWrapper, HBox contentBox) {
        return null;
    }

    // Method ini tidak dipanggil, jadi tidak wajib diubah, tapi jika ingin
    // dipanggil, harus diubah agar tidak error.
    private VBox createProfileCard() {
        VBox card = new VBox(20);
        // ... (sisa implementasi tidak berubah)

        // DIKOMENTARI: Blok kode yang bergantung pada DatabaseConnection dan Member
        /*
        Member dbMember = member;
        if (dbMember == null) {
            try {
                Connection conn = DatabaseConnection.getConnection();
                String query = "SELECT * FROM member LIMIT 1";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                if (rs.next()) {
                    dbMember = new Member(
                        rs.getString("nama"),
                        rs.getString("fakultas"),
                        rs.getString("prodi"),
                        rs.getString("no_hp"),
                        rs.getString("email"),
                        rs.getString("nim")
                    );
                }
                rs.close();
                stmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        */

        // ... (sisa implementasi bisa menggunakan data dummy jika diperlukan)
        return card;
    }

    // Sisa method (createStatsCard, showProfileContent, etc.) tidak perlu diubah
    // karena mereka sudah memanggil method yang telah dimodifikasi atau tidak
    // bergantung pada kelas eksternal secara langsung.

    // ... (Salin sisa method dari kode asli Anda di sini)
    private VBox createStatsCard() {
        VBox card = new VBox(20);
        card.setPadding(new Insets(25));
        card.setStyle("-fx-background-color: white; -fx-background-radius: 15; "
                + "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.1), 20, 0, 0, 4);");
        card.setPrefWidth(400);

        Label title = new Label("Borrowing Statistics");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        title.setTextFill(Color.web("#2c3e50"));

        // Statistik
        String[] stats = {
                "Active Borrowings: 3 books",
                "Overdue Books: 0",
                "Total Borrowed: 12 books",
                "Favorite Category: Computer Science"
        };

        VBox statsList = new VBox(15);
        for (String stat : stats) {
            HBox item = new HBox(15);
            item.setAlignment(Pos.CENTER_LEFT);

            Circle bullet = new Circle(5, Color.web("#3498db"));
            Label text = new Label(stat);
            text.setFont(Font.font("Arial", 14));
            text.setTextFill(Color.web("#34495e"));

            item.getChildren().addAll(bullet, text);
            statsList.getChildren().add(item);
        }

        card.getChildren().addAll(title, statsList);
        return card;
    }

    private void showProfileContent(Stage primaryStage) {
        VBox mainContent = createProfileContent(true);

        try {
            StackPane rootStackPane = (StackPane) primaryStage.getScene().getRoot();
            BorderPane rootPane = (BorderPane) rootStackPane.getChildren().get(0);
            rootPane.setCenter(mainContent);
        } catch (Exception ex) {
            System.err.println("Error updating content: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    private void showBorrowedBooksContent(Stage primaryStage) {
        VBox mainContent = new VBox(18);
        mainContent.setPadding(new Insets(30, 30, 30, 30));
        mainContent.setStyle("-fx-background-color: #f8f9fa;");

        VBox whitePanel = new VBox(18);
        whitePanel.setPadding(new Insets(30, 30, 30, 30));
        whitePanel.setAlignment(Pos.TOP_LEFT);
        whitePanel.setStyle("-fx-background-color: #fff; -fx-background-radius: 10;");

        Label title = new Label("Borrow Book Menu");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 22));
        title.setTextFill(Color.web("#888"));
        title.setPadding(new Insets(0, 0, 30, 0));

        VBox menuButtonsContainer = new VBox(20);
        menuButtonsContainer.setAlignment(Pos.CENTER);
        menuButtonsContainer.setPadding(new Insets(20, 0, 20, 0));

        VBox borrowFormButton = createBorrowMenuButton("Borrow Book", () -> showBorrowFormContent(primaryStage));
        VBox currentBorrowedButton = createBorrowMenuButton("Currently Borrowed", () -> showCurrentBorrowedContent(primaryStage));
        VBox borrowHistoryButton = createBorrowMenuButton("Borrowing History", () -> showBorrowHistoryContent(primaryStage));

        menuButtonsContainer.getChildren().addAll(borrowFormButton, currentBorrowedButton, borrowHistoryButton);

        Button backButton = new Button("Kembali ke Profile");
        backButton.setStyle("-fx-background-color: #7ea6c7; -fx-text-fill: white; -fx-font-size: 14px; -fx-background-radius: 8;");
        backButton.setPadding(new Insets(10, 20, 10, 20));
        backButton.setOnAction(e -> showProfileContent(primaryStage));

        whitePanel.getChildren().addAll(title, menuButtonsContainer, backButton);
        mainContent.getChildren().add(whitePanel);

        try {
            StackPane rootStackPane = (StackPane) primaryStage.getScene().getRoot();
            BorderPane rootPane = (BorderPane) rootStackPane.getChildren().get(0);
            rootPane.setCenter(mainContent);
        } catch (Exception ex) {
            System.err.println("Error updating content: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    private VBox createBorrowMenuButton(String text, Runnable action) {
        VBox button = new VBox(10);
        button.setAlignment(Pos.CENTER);
        button.setPadding(new Insets(20));
        button.setPrefSize(200, 180);
        button.setStyle("-fx-background-color: #f7f7f7; -fx-background-radius: 10; -fx-border-radius: 10; -fx-border-color: #e3e3e3; -fx-border-width: 1; -fx-cursor: hand;");

        ImageView imageView = null;
        try {
            Image image = new Image("file:src/heli.jpg");
            imageView = new ImageView(image);
            imageView.setFitWidth(80);
            imageView.setFitHeight(80);
            imageView.setPreserveRatio(true);
        } catch (Exception e) {
            Circle placeholder = new Circle(40, Color.web("#bdc3c7"));
            Label placeholderText = new Label("IMG");
            placeholderText.setFont(Font.font("Arial", FontWeight.BOLD, 12));
            placeholderText.setTextFill(Color.WHITE);
            StackPane placeholderPane = new StackPane(placeholder, placeholderText);
            button.getChildren().add(placeholderPane);
        }

        if (imageView != null) {
            button.getChildren().add(imageView);
        }

        Label label = new Label(text);
        label.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        label.setTextFill(Color.web("#444"));
        label.setTextAlignment(TextAlignment.CENTER);
        label.setAlignment(Pos.CENTER);

        button.getChildren().add(label);

        button.setOnMouseEntered(e -> {
            button.setStyle("-fx-background-color: #e8f4fd; -fx-background-radius: 10; -fx-border-radius: 10; -fx-border-color: #7ea6c7; -fx-border-width: 2; -fx-cursor: hand;");
        });

        button.setOnMouseExited(e -> {
            button.setStyle("-fx-background-color: #f7f7f7; -fx-background-radius: 10; -fx-border-radius: 10; -fx-border-color: #e3e3e3; -fx-border-width: 1; -fx-cursor: hand;");
        });

        button.setOnMouseClicked(e -> action.run());

        return button;
    }

    private void showBorrowFormContent(Stage primaryStage) {
        VBox mainContent = new VBox(18);
        mainContent.setPadding(new Insets(30, 30, 30, 30));
        mainContent.setStyle("-fx-background-color: #f8f9fa;");

        VBox whitePanel = new VBox(18);
        whitePanel.setPadding(new Insets(30, 30, 30, 30));
        whitePanel.setAlignment(Pos.TOP_LEFT);
        whitePanel.setStyle("-fx-background-color: #fff; -fx-background-radius: 10;");

        Label title = new Label("Form Pengisian Peminjaman Buku");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 22));
        title.setTextFill(Color.web("#888"));
        title.setPadding(new Insets(0, 0, 18, 0));

        VBox formContainer = new VBox(15);
        formContainer.setStyle("-fx-background-color: #f7f7f7; -fx-background-radius: 7; -fx-border-radius: 7; -fx-border-color: #e3e3e3; -fx-border-width: 1;");
        formContainer.setPadding(new Insets(20));

        TextField bookIdField = new TextField();
        bookIdField.setPromptText("ID Buku");
        bookIdField.setPrefHeight(35);

        TextField bookTitleField = new TextField();
        bookTitleField.setPromptText("Judul Buku");
        bookTitleField.setPrefHeight(35);

        TextField borrowerNameField;
        borrowerNameField = new TextField();
        borrowerNameField.setPromptText("Nama Peminjam");
        borrowerNameField.setPrefHeight(35);

        TextField borrowerIDField;
        borrowerIDField = new TextField();
        borrowerIDField.setPromptText("NIM Peminjam");
        borrowerIDField.setPrefHeight(35);

        DatePicker borrowDatePicker = new DatePicker();
        borrowDatePicker.setPromptText("Tanggal Peminjaman");
        borrowDatePicker.setPrefHeight(35);

        DatePicker returnDatePicker = new DatePicker();
        returnDatePicker.setPromptText("Tanggal Pengembalian");
        returnDatePicker.setPrefHeight(35);

        Button submitButton = new Button("Ajukan Peminjaman");
        submitButton.setStyle("-fx-background-color: #7ea6c7; -fx-text-fill: white; -fx-font-size: 14px; -fx-background-radius: 8;");
        submitButton.setPadding(new Insets(10, 20, 10, 20));

        formContainer.getChildren().addAll(bookIdField, bookTitleField, borrowerNameField, borrowerIDField, borrowDatePicker, returnDatePicker, submitButton);

        Button backButton = new Button("Kembali ke Borrow Book Menu");
        backButton.setStyle("-fx-background-color: #6c757d; -fx-text-fill: white; -fx-font-size: 14px; -fx-background-radius: 8;");
        backButton.setPadding(new Insets(10, 20, 10, 20));
        backButton.setOnAction(e -> showBorrowedBooksContent(primaryStage));

        whitePanel.getChildren().addAll(title, formContainer, backButton);
        mainContent.getChildren().add(whitePanel);

        updateMainContent(primaryStage, mainContent);
    }

    private void showCurrentBorrowedContent(Stage primaryStage) {
        VBox mainContent = new VBox(18);
        mainContent.setPadding(new Insets(30, 30, 30, 30));
        mainContent.setStyle("-fx-background-color: #f8f9fa;");

        VBox whitePanel = new VBox(18);
        whitePanel.setPadding(new Insets(30, 30, 30, 30));
        whitePanel.setAlignment(Pos.TOP_LEFT);
        whitePanel.setStyle("-fx-background-color: #fff; -fx-background-radius: 10;");

        Label title = new Label("Currently Borrowed Books");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 22));
        title.setTextFill(Color.web("#888"));
        title.setPadding(new Insets(0, 0, 18, 0));

        VBox borrowedContainer = new VBox(15);
        borrowedContainer.setStyle("-fx-background-color: #f7f7f7; -fx-background-radius: 7; -fx-border-radius: 7; -fx-border-color: #e3e3e3; -fx-border-width: 1;");
        borrowedContainer.setPadding(new Insets(20));
        borrowedContainer.setAlignment(Pos.CENTER);

        Label info = new Label("Tidak ada buku yang sedang dipinjam");
        info.setFont(Font.font("Arial", FontWeight.NORMAL, 16));
        info.setTextFill(Color.web("#666"));

        borrowedContainer.getChildren().add(info);

        Button backButton = new Button("Kembali ke Borrow Book Menu");
        backButton.setStyle("-fx-background-color: #6c757d; -fx-text-fill: white; -fx-font-size: 14px; -fx-background-radius: 8;");
        backButton.setPadding(new Insets(10, 20, 10, 20));
        backButton.setOnAction(e -> showBorrowedBooksContent(primaryStage));

        whitePanel.getChildren().addAll(title, borrowedContainer, backButton);
        mainContent.getChildren().add(whitePanel);

        updateMainContent(primaryStage, mainContent);
    }

    private void showBorrowHistoryContent(Stage primaryStage) {
        VBox mainContent = new VBox(18);
        mainContent.setPadding(new Insets(30, 30, 30, 30));
        mainContent.setStyle("-fx-background-color: #f8f9fa;");

        VBox whitePanel = new VBox(18);
        whitePanel.setPadding(new Insets(30, 30, 30, 30));
        whitePanel.setAlignment(Pos.TOP_LEFT);
        whitePanel.setStyle("-fx-background-color: #fff; -fx-background-radius: 10;");

        Label title = new Label("Borrowing History");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 22));
        title.setTextFill(Color.web("#888"));
        title.setPadding(new Insets(0, 0, 18, 0));

        VBox historyContainer = new VBox(15);
        historyContainer.setStyle("-fx-background-color: #f7f7f7; -fx-background-radius: 7; -fx-border-radius: 7; -fx-border-color: #e3e3e3; -fx-border-width: 1;");
        historyContainer.setPadding(new Insets(20));

        Label info = new Label("Riwayat peminjaman buku akan ditampilkan di sini");
        info.setFont(Font.font("Arial", FontWeight.NORMAL, 16));
        info.setTextFill(Color.web("#666"));

        historyContainer.getChildren().add(info);

        Button backButton = new Button("Kembali ke Borrow Book Menu");
        backButton.setStyle("-fx-background-color: #6c757d; -fx-text-fill: white; -fx-font-size: 14px; -fx-background-radius: 8;");
        backButton.setPadding(new Insets(10, 20, 10, 20));
        backButton.setOnAction(e -> showBorrowedBooksContent(primaryStage));

        whitePanel.getChildren().addAll(title, historyContainer, backButton);
        mainContent.getChildren().add(whitePanel);

        updateMainContent(primaryStage, mainContent);
    }

    private void updateMainContent(Stage primaryStage, VBox mainContent) {
        try {
            StackPane rootStackPane = (StackPane) primaryStage.getScene().getRoot();
            BorderPane rootPane = (BorderPane) rootStackPane.getChildren().get(0);
            rootPane.setCenter(mainContent);
        } catch (Exception ex) {
            System.err.println("Error updating content: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    private void showReturnBookContent(Stage primaryStage) {
        VBox mainContent = new VBox(18);
        mainContent.setPadding(new Insets(30, 30, 30, 30));
        mainContent.setStyle("-fx-background-color: #f8f9fa;");

        VBox whitePanel = new VBox(18);
        whitePanel.setPadding(new Insets(30, 30, 30, 30));
        whitePanel.setAlignment(Pos.TOP_LEFT);
        whitePanel.setStyle("-fx-background-color: #fff; -fx-background-radius: 10;");

        Label title = new Label("Pengembalian Buku");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 22));
        title.setTextFill(Color.web("#888"));
        title.setPadding(new Insets(0, 0, 18, 0));

        VBox returnContainer = new VBox(15);
        returnContainer.setStyle("-fx-background-color: #f7f7f7; -fx-background-radius: 7; -fx-border-radius: 7; -fx-border-color: #e3e3e3; -fx-border-width: 1;");
        returnContainer.setPadding(new Insets(20));

        Label info = new Label("Form pengembalian buku akan ditampilkan di sini");
        info.setFont(Font.font("Arial", FontWeight.NORMAL, 16));
        info.setTextFill(Color.web("#666"));

        returnContainer.getChildren().add(info);

        Button backButton = new Button("Kembali ke Profile");
        backButton.setStyle("-fx-background-color: #7ea6c7; -fx-text-fill: white; -fx-font-size: 14px; -fx-background-radius: 8;");
        backButton.setPadding(new Insets(10, 20, 10, 20));
        backButton.setOnAction(e -> showProfileContent(primaryStage));

        whitePanel.getChildren().addAll(title, returnContainer, backButton);
        mainContent.getChildren().add(whitePanel);

        try {
            StackPane rootStackPane = (StackPane) primaryStage.getScene().getRoot();
            BorderPane rootPane = (BorderPane) rootStackPane.getChildren().get(0);
            rootPane.setCenter(mainContent);
        } catch (Exception ex) {
            System.err.println("Error updating content: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    private void showSearchBookContent(Stage primaryStage) {
        VBox mainContent = new VBox(18);
        mainContent.setPadding(new Insets(30, 30, 30, 30));
        mainContent.setStyle("-fx-background-color: #f8f9fa;");

        VBox whitePanel = new VBox(18);
        whitePanel.setPadding(new Insets(30, 30, 30, 30));
        whitePanel.setAlignment(Pos.TOP_LEFT);
        whitePanel.setStyle("-fx-background-color: #fff; -fx-background-radius: 10;");

        Label title = new Label("Search Book Menu");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 22));
        title.setTextFill(Color.web("#888"));
        title.setPadding(new Insets(0, 0, 30, 0));

        VBox menuButtonsContainer = new VBox(20);
        menuButtonsContainer.setAlignment(Pos.CENTER);
        menuButtonsContainer.setPadding(new Insets(20, 0, 20, 0));

        // Tiga tombol panel seperti di Borrow Menu
        VBox searchByTitle = createBorrowMenuButton("Search Book", () -> showSearchForm(primaryStage, "Judul"));
        VBox searchByAuthor = createBorrowMenuButton("Search by Author", () -> showSearchForm(primaryStage, "Penulis"));
        VBox searchByCategory = createBorrowMenuButton("Select Genre", () -> showSearchForm(primaryStage, "Genre"));

        menuButtonsContainer.getChildren().addAll(searchByTitle, searchByAuthor, searchByCategory);

        Button backButton = new Button("Kembali ke Profile");
        backButton.setStyle("-fx-background-color: #7ea6c7; -fx-text-fill: white; -fx-font-size: 14px; -fx-background-radius: 8;");
        backButton.setPadding(new Insets(10, 20, 10, 20));
        backButton.setOnAction(e -> showProfileContent(primaryStage)); // Ganti sesuai halaman utama kamu

        whitePanel.getChildren().addAll(title, menuButtonsContainer, backButton);
        mainContent.getChildren().add(whitePanel);

        updateMainContent(primaryStage, mainContent);
    }

    private void showSearchForm(Stage primaryStage, String mode) {
        VBox mainContent = new VBox(20);
        mainContent.setPadding(new Insets(40));
        mainContent.setAlignment(Pos.TOP_CENTER);
        mainContent.setStyle("-fx-background-color: #f8f9fa;");

        VBox formPanel = new VBox(20);
        formPanel.setPadding(new Insets(30));
        formPanel.setAlignment(Pos.CENTER_LEFT);
        formPanel.setMaxWidth(500);
        formPanel.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 10; -fx-border-color: #dddddd; -fx-border-radius: 10;");

        Label title = new Label("Form Pencarian Buku Berdasarkan " + mode.toUpperCase());
        title.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        title.setTextFill(Color.web("#333"));

        TextField searchField = new TextField();
        searchField.setPromptText("Masukkan " + mode);
        searchField.setPrefHeight(35);
        searchField.setMaxWidth(Double.MAX_VALUE);

        Button searchButton = new Button("Cari");
        searchButton.setStyle("-fx-background-color: #7ea6c7; -fx-text-fill: white; -fx-font-size: 14px; -fx-background-radius: 8;");
        searchButton.setPadding(new Insets(10, 20, 10, 20));

        Button backButton = new Button("Kembali ke Search Book Menu");
        backButton.setStyle("-fx-background-color: #6c757d; -fx-text-fill: white; -fx-font-size: 14px; -fx-background-radius: 8;");
        backButton.setPadding(new Insets(10, 20, 10, 20));
        backButton.setOnAction(e -> showSearchBookContent(primaryStage)); // Ganti dengan fungsi untuk kembali ke profil

        formPanel.getChildren().addAll(title, searchField, searchButton, backButton);
        mainContent.getChildren().add(formPanel);

        updateMainContent(primaryStage, mainContent);
    }

    public static void main(String[] args) {
        launch(args);
    }
}