package notepad;

import java.awt.datatransfer.Clipboard;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.text.Text;

public class Notepad extends Application{

	
	public Notepad() {
		
	}

	@Override
	public void start(Stage primaryStage) {
		
		// create text area
		TextArea text_area = new TextArea();
        text_area.setStyle("-fx-font: 24 arial;");
		// menu file
		Menu file = new Menu("file");
		MenuItem I_new = new MenuItem("New"); 
        MenuItem I_open = new MenuItem("Open"); 
        MenuItem I_save = new MenuItem("Save"); 
		MenuItem I_exit = new MenuItem("Exit");
		
		// adding events to items
		I_new.setOnAction(new EventHandler<ActionEvent>() {	
			@Override
			public void handle(ActionEvent event) {
				FileChooser fileChooser = new FileChooser();
	            
	            //Set extension filter
	            FileChooser.ExtensionFilter extFilter = 
	            new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
	            fileChooser.getExtensionFilters().add(extFilter);
	            
	            //Show save file dialog
	            File file = fileChooser.showSaveDialog(primaryStage);
	            
	            if(file != null){
	                SaveFile(text_area.getText(), file);
	            }
			}
		});
		
		I_open.setOnAction(new EventHandler<ActionEvent>() {	
			@Override
			public void handle(ActionEvent event) {
				FileChooser fileChooser = new FileChooser();
                
                //Set extension filter
                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
                fileChooser.getExtensionFilters().add(extFilter);
                 
                //Show save file dialog
                File file = fileChooser.showOpenDialog(primaryStage);
                if(file != null){
                    text_area.setText(readFile(file));
                }
			}
		});
		
		I_save.setOnAction(new EventHandler<ActionEvent>() {	
			@Override
			public void handle(ActionEvent event) {
				FileChooser fileChooser = new FileChooser();
	            
	            //Set extension filter
	            FileChooser.ExtensionFilter extFilter = 
	                new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
	            fileChooser.getExtensionFilters().add(extFilter);
	            
	            //Show save file dialog
	            File file = fileChooser.showSaveDialog(primaryStage);
	            
	            if(file != null){
	                SaveFile(text_area.getText(), file);
	            }
			}
		});
		
		I_exit.setOnAction(new EventHandler<ActionEvent>() {	
			@Override
			public void handle(ActionEvent event) {
				Platform.exit();
			}
		});
		
		// adding items to menu
		file.getItems().add(I_new);
		file.getItems().add(I_open);
		file.getItems().add(I_save);
		file.getItems().add(I_exit);
		
		Menu edit = new Menu("edit");
		MenuItem I_undo = new MenuItem("Un do"); 
        MenuItem I_cut = new MenuItem("Cut");
        
     // add shortcuts for copy and past
        MenuItem I_copy = new MenuItem("Copy");
        I_copy.setAccelerator(KeyCombination.keyCombination("Ctrl+o"));
		MenuItem I_past = new MenuItem("Past");
		I_past.setAccelerator(KeyCombination.keyCombination("Ctrl+p"));
		MenuItem I_delete = new MenuItem("Delete"); 
        MenuItem I_select_all = new MenuItem("Select All"); 
        
     // adding events to items
 		I_undo.setOnAction(new EventHandler<ActionEvent>() {	
 			@Override
 			public void handle(ActionEvent event) {
 				text_area.undo();
 			}
 		});
 		
 		I_cut.setOnAction(new EventHandler<ActionEvent>() {	
 			@Override
 			public void handle(ActionEvent event) {
 				text_area.cut();
 			}
 		});
 		
 		I_copy.setOnAction(new EventHandler<ActionEvent>() {	
 			@Override
 			public void handle(ActionEvent event) {
 				text_area.copy();
 			}
 		});
 		
 		I_past.setOnAction(new EventHandler<ActionEvent>() {	
 			@Override
 			public void handle(ActionEvent event) {
 				text_area.paste();
 			}
 		});
 		
 		I_delete.setOnAction(new EventHandler<ActionEvent>() {	
 			@Override
 			public void handle(ActionEvent event) {
 				text_area.deleteText(text_area.getSelection().getStart(), text_area.getSelection().getEnd());
 			}
 		});
 		
 		I_select_all.setOnAction(new EventHandler<ActionEvent>() {	
 			@Override
 			public void handle(ActionEvent event) {
 				text_area.selectAll();
 			}
 		});
        
        edit.getItems().add(I_undo);
        edit.getItems().add(I_cut);
        edit.getItems().add(I_copy);
        edit.getItems().add(I_past);
        edit.getItems().add(I_delete);
        edit.getItems().add(I_select_all);
        
        // create help menu
		Menu help = new Menu("help");
		MenuItem I_about = new MenuItem("About NotePad");
		
		I_about.setOnAction(new EventHandler<ActionEvent>() {	
			@Override
			public void handle(ActionEvent event) {
				final Stage dialog = new Stage();
                dialog.initModality(Modality.APPLICATION_MODAL);
                dialog.initOwner(primaryStage);
                VBox dialogVbox = new VBox(20);
                Text tt = new Text("This is a notepad in javaFx");
                tt.setStyle("-fx-font: 20 arial;");
                dialogVbox.getChildren().add(tt);
                Scene dialogScene = new Scene(dialogVbox, 300, 100);
                dialog.setScene(dialogScene);
                dialog.show();
			}
		});
		
		help.getItems().add(I_about);
		
		// create a menubar 
        MenuBar mb = new MenuBar(); 
        mb.getMenus().addAll(file, edit, help);
        
        
        // create border pane
        BorderPane root_pane = new BorderPane();
        root_pane.setTop(mb);
        root_pane.setCenter(text_area);
        
        
		Scene scene = new Scene(root_pane, 500, 500);

		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	// open file method
	  private String readFile(File file){
	        StringBuilder stringBuffer = new StringBuilder();
	        BufferedReader bufferedReader = null;
	        try {
	            bufferedReader = new BufferedReader(new FileReader(file));             
	            String text;
	            while ((text = bufferedReader.readLine()) != null) {
	                stringBuffer.append(text);
	            }
	 
	        } catch (FileNotFoundException ex) {
	            Logger.getLogger(Notepad.class.getName()).log(Level.SEVERE, null, ex);
	        } catch (IOException ex) {
	            Logger.getLogger(Notepad.class.getName()).log(Level.SEVERE, null, ex);
	        } finally {
	            try {
	                bufferedReader.close();
	            } catch (IOException ex) {
	                Logger.getLogger(Notepad.class.getName()).log(Level.SEVERE, null, ex);
	            }
	        } 
	         
	        return stringBuffer.toString();
	    }
	
	// save file method
	private void SaveFile(String content, File file){
        try {
            FileWriter fileWriter;
             
            fileWriter = new FileWriter(file);
            fileWriter.write(content);
            fileWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(Notepad.class
                .getName()).log(Level.SEVERE, null, ex);
        }
         
    }
	
	public static void main(String [] args) {
		Application.launch(args);
	}
}
