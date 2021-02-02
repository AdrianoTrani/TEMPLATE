package logic;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MainClassGradle extends Application{
	
	//DICHIARAZIONE
		Label labelResult;
		
		Button buttonCancel;
		Button buttonCancelAll;
		
		Button buttonAdd;
		Button buttonSub;
		Button buttonMul;
		Button buttonDiv;
		Button buttonEq;
		
		Button button0;
		Button button1;
		Button button2;
		Button button3;
		Button button4;
		Button button5;
		Button button6;
		Button button7;
		Button button8;
		Button button9;
		
		Button buttonPlaceHolder1;
		Button buttonPlaceHolder2;
		Button buttonPlaceHolder3;
		Button buttonPlaceHolder4;
		Button buttonPlaceHolder5;
		
		Boolean isResetNeeded; //impostato a true ogni volta che avviene un errore
		Double firstNumber; //primo operando
		Double secondNumber; //secondo operando
		Integer operation; 
		/* OPERATION
		 * -1 = ho già il primo operando, ora è tempo di scegliere l'operazione
		 * 0 = reset totale
		 * 1 = addizione
		 * 2 = sottrazione
		 * 3 = moltiplicazione
		 * 4 = divisione
		 * 5 = future operazioni
		 */
		
		
		public static void main(String[] args) {
			launch(args);
		}
		
		@Override
		public void start(Stage primaryStage) throws Exception {
			primaryStage.setTitle("TEMPLATE");
			
			VBox root = new VBox();
			HBox row1 = new HBox();
			HBox row2 = new HBox();
			HBox row3 = new HBox();
			HBox row4 = new HBox();
			HBox row5 = new HBox();
			HBox row6 = new HBox();
			HBox row7 = new HBox();
			
			
			Scene sceneTest01 = new Scene(root, 200, 340);
			primaryStage.setScene(sceneTest01);
			
			//- - - - - <INIZIALIZZAZIONI LOGICHE> - - - - - - - - - - - - - - - - - - - -
			operation = 0;
			isResetNeeded = false;
			//- - - - - <INIZIALIZZAZIONI GRAFICHE> - - - - - - - - - - - - - - - - - - - -
			Font tempFont = new Font(20);
			Double prefButtonHeight = 50.0;
			Double prefButtonWidth = 50.0;
			Double prefResultLabelHeight = 40.0;
			Double prefResultLabelWidth = 200.0;
			Double prefCancelButtonHeight = 50.0;
			Double prefCancelButtonWidth = 100.0;
			
			
			labelResult = new Label("Waiting Input...");
			
			buttonCancel = new Button("Canc");
			buttonCancelAll = new Button("Reset");
			
			buttonAdd = new Button("+");
			buttonSub = new Button("-");
			buttonMul = new Button("*");
			buttonDiv = new Button("/");
			buttonEq = new Button("=");
			
			button0 = new Button("0");
			button1 = new Button("1");
			button2 = new Button("2");
			button3 = new Button("3");
			button4 = new Button("4");
			button5 = new Button("5");
			button6 = new Button("6");
			button7 = new Button("7");
			button8 = new Button("8");
			button9 = new Button("9");
			
			buttonPlaceHolder1 = new Button(" ");
			buttonPlaceHolder2 = new Button(" ");
			buttonPlaceHolder3 = new Button(" ");
			buttonPlaceHolder4 = new Button(" ");
			buttonPlaceHolder5 = new Button(" ");
			
			//IMPOSTAZIONI GRAFICHE (LABEL RESULT)
			labelResult.setPrefHeight(prefResultLabelHeight);
			labelResult.setPrefWidth(prefResultLabelWidth);
			labelResult.setTextFill(Color.BLACK);
			labelResult.setStyle("-fx-background-color: #FFFFFF; -fx-background-radius:1; -fx-border-color:black; -fx-border-width: 1 1 1 1;");
			labelResult.setFont(tempFont);
			
			//IMPOSTAZIONI GRAFICHE (CANCEL)
			buttonCancel.setPrefHeight(prefCancelButtonHeight);
			buttonCancel.setPrefWidth(prefCancelButtonWidth);
			buttonCancel.setTextFill(Color.BLACK);
			buttonCancel.setStyle("-fx-background-color: #FF8F00; -fx-background-radius:1; -fx-border-color:black; -fx-border-width: 1 1 1 1;");
			buttonCancel.setFont(tempFont);
			
			//IMPOSTAZIONI GRAFICHE (CANCEL ALL)
			buttonCancelAll.setPrefHeight(prefCancelButtonHeight);
			buttonCancelAll.setPrefWidth(prefCancelButtonWidth);
			buttonCancelAll.setTextFill(Color.BLACK);
			buttonCancelAll.setStyle("-fx-background-color: #FF8F00; -fx-background-radius:1; -fx-border-color:black; -fx-border-width: 1 1 1 1;");
			buttonCancelAll.setFont(tempFont);
			
			//IMPOSTAZIONI GRAFICHE (+)
			buttonAdd.setPrefHeight(prefButtonHeight);
			buttonAdd.setPrefWidth(prefButtonWidth);
			buttonAdd.setTextFill(Color.BLACK);
			buttonAdd.setStyle("-fx-background-color: #00FF8F; -fx-background-radius:1; -fx-border-color:black; -fx-border-width: 1 1 1 1;");
			buttonAdd.setFont(tempFont);
			
			//IMPOSTAZIONI GRAFICHE (-)
			buttonSub.setPrefHeight(prefButtonHeight);
			buttonSub.setPrefWidth(prefButtonWidth);
			buttonSub.setTextFill(Color.BLACK);
			buttonSub.setFont(tempFont);
			buttonSub.setStyle("-fx-background-color: #00FF8F; -fx-background-radius:1; -fx-border-color:black; -fx-border-width: 1 1 1 1;");
			
			//IMPOSTAZIONI GRAFICHE (*)
			buttonMul.setPrefHeight(prefButtonHeight);
			buttonMul.setPrefWidth(prefButtonWidth);
			buttonMul.setTextFill(Color.BLACK);
			buttonMul.setFont(tempFont);
			buttonMul.setStyle("-fx-background-color: #00FF8F; -fx-background-radius:1; -fx-border-color:black; -fx-border-width: 1 1 1 1;");
		
			//IMPOSTAZIONI GRAFICHE (/)
			buttonDiv.setPrefHeight(prefButtonHeight);
			buttonDiv.setPrefWidth(prefButtonWidth);
			buttonDiv.setTextFill(Color.BLACK);
			buttonDiv.setFont(tempFont);
			buttonDiv.setStyle("-fx-background-color: #00FF8F; -fx-background-radius:1; -fx-border-color:black; -fx-border-width: 1 1 1 1;");
		
			//IMPOSTAZIONI GRAFICHE (=)
			buttonEq.setPrefHeight(prefButtonHeight);
			buttonEq.setPrefWidth(prefButtonWidth);
			buttonEq.setTextFill(Color.BLACK);
			buttonEq.setFont(tempFont);
			buttonEq.setStyle("-fx-background-color: #00FF8F; -fx-background-radius:1; -fx-border-color:black; -fx-border-width: 1 1 1 1;");
			
			//IMPOSTAZIONI GRAFICHE (0)
			button0.setPrefHeight(prefButtonHeight);
			button0.setPrefWidth(prefButtonWidth);
			button0.setTextFill(Color.BLACK);
			button0.setFont(tempFont);
			button0.setStyle("-fx-background-color: #00FF8F; -fx-background-radius:1; -fx-border-color:black; -fx-border-width: 1 1 1 1;");
			
			//IMPOSTAZIONI GRAFICHE (1)
			button1.setPrefHeight(prefButtonHeight);
			button1.setPrefWidth(prefButtonWidth);
			button1.setTextFill(Color.BLACK);
			button1.setFont(tempFont);
			button1.setStyle("-fx-background-color: #00FF8F; -fx-background-radius:1; -fx-border-color:black; -fx-border-width: 1 1 1 1;");
			
			//IMPOSTAZIONI GRAFICHE (2)
			button2.setPrefHeight(prefButtonHeight);
			button2.setPrefWidth(prefButtonWidth);
			button2.setTextFill(Color.BLACK);
			button2.setFont(tempFont);
			button2.setStyle("-fx-background-color: #00FF8F; -fx-background-radius:1; -fx-border-color:black; -fx-border-width: 1 1 1 1;");
			
			//IMPOSTAZIONI GRAFICHE (3)
			button3.setPrefHeight(prefButtonHeight);
			button3.setPrefWidth(prefButtonWidth);
			button3.setTextFill(Color.BLACK);
			button3.setFont(tempFont);
			button3.setStyle("-fx-background-color: #00FF8F; -fx-background-radius:1; -fx-border-color:black; -fx-border-width: 1 1 1 1;");
			
			//IMPOSTAZIONI GRAFICHE (4)
			button4.setPrefHeight(prefButtonHeight);
			button4.setPrefWidth(prefButtonWidth);
			button4.setTextFill(Color.BLACK);
			button4.setFont(tempFont);
			button4.setStyle("-fx-background-color: #00FF8F; -fx-background-radius:1; -fx-border-color:black; -fx-border-width: 1 1 1 1;");
			
			//IMPOSTAZIONI GRAFICHE (5)
			button5.setPrefHeight(prefButtonHeight);
			button5.setPrefWidth(prefButtonWidth);
			button5.setTextFill(Color.BLACK);
			button5.setFont(tempFont);
			button5.setStyle("-fx-background-color: #00FF8F; -fx-background-radius:1; -fx-border-color:black; -fx-border-width: 1 1 1 1;");
			
			//IMPOSTAZIONI GRAFICHE (6)
			button6.setPrefHeight(prefButtonHeight);
			button6.setPrefWidth(prefButtonWidth);
			button6.setTextFill(Color.BLACK);
			button6.setFont(tempFont);
			button6.setStyle("-fx-background-color: #00FF8F; -fx-background-radius:1; -fx-border-color:black; -fx-border-width: 1 1 1 1;");
			
			//IMPOSTAZIONI GRAFICHE (7)
			button7.setPrefHeight(prefButtonHeight);
			button7.setPrefWidth(prefButtonWidth);
			button7.setTextFill(Color.BLACK);
			button7.setFont(tempFont);
			button7.setStyle("-fx-background-color: #00FF8F; -fx-background-radius:1; -fx-border-color:black; -fx-border-width: 1 1 1 1;");
			
			//IMPOSTAZIONI GRAFICHE (8)
			button8.setPrefHeight(prefButtonHeight);
			button8.setPrefWidth(prefButtonWidth);
			button8.setTextFill(Color.BLACK);
			button8.setFont(tempFont);
			button8.setStyle("-fx-background-color: #00FF8F; -fx-background-radius:1; -fx-border-color:black; -fx-border-width: 1 1 1 1;");
			
			//IMPOSTAZIONI GRAFICHE (9)
			button9.setPrefHeight(prefButtonHeight);
			button9.setPrefWidth(prefButtonWidth);
			button9.setTextFill(Color.BLACK);
			button9.setFont(tempFont);
			button9.setStyle("-fx-background-color: #00FF8F; -fx-background-radius:1; -fx-border-color:black; -fx-border-width: 1 1 1 1;");
			
			//IMPOSTAZIONI GRAFICHE ()
			buttonPlaceHolder1.setPrefHeight(prefButtonHeight);
			buttonPlaceHolder1.setPrefWidth(prefButtonWidth);
			buttonPlaceHolder1.setTextFill(Color.BLACK);
			buttonPlaceHolder1.setFont(tempFont);
			buttonPlaceHolder1.setStyle("-fx-background-color: #00FF8F; -fx-background-radius:1; -fx-border-color:black; -fx-border-width: 1 1 1 1;");
			
			//IMPOSTAZIONI GRAFICHE ()
			buttonPlaceHolder2.setPrefHeight(prefButtonHeight);
			buttonPlaceHolder2.setPrefWidth(prefButtonWidth);
			buttonPlaceHolder2.setTextFill(Color.BLACK);
			buttonPlaceHolder2.setFont(tempFont);
			buttonPlaceHolder2.setStyle("-fx-background-color: #00FF8F; -fx-background-radius:1; -fx-border-color:black; -fx-border-width: 1 1 1 1;");
			
			//IMPOSTAZIONI GRAFICHE ()
			buttonPlaceHolder3.setPrefHeight(prefButtonHeight);
			buttonPlaceHolder3.setPrefWidth(prefButtonWidth);
			buttonPlaceHolder3.setTextFill(Color.BLACK);
			buttonPlaceHolder3.setFont(tempFont);
			buttonPlaceHolder3.setStyle("-fx-background-color: #00FF8F; -fx-background-radius:1; -fx-border-color:black; -fx-border-width: 1 1 1 1;");
			
			//IMPOSTAZIONI GRAFICHE ()
			buttonPlaceHolder4.setPrefHeight(prefButtonHeight);
			buttonPlaceHolder4.setPrefWidth(prefButtonWidth);
			buttonPlaceHolder4.setTextFill(Color.BLACK);
			buttonPlaceHolder4.setFont(tempFont);
			buttonPlaceHolder4.setStyle("-fx-background-color: #00FF8F; -fx-background-radius:1; -fx-border-color:black; -fx-border-width: 1 1 1 1;");
			
			//IMPOSTAZIONI GRAFICHE ()
			buttonPlaceHolder5.setPrefHeight(prefButtonHeight);
			buttonPlaceHolder5.setPrefWidth(prefButtonWidth);
			buttonPlaceHolder5.setTextFill(Color.BLACK);
			buttonPlaceHolder5.setFont(tempFont);
			buttonPlaceHolder5.setStyle("-fx-background-color: #00FF8F; -fx-background-radius:1; -fx-border-color:black; -fx-border-width: 1 1 1 1;");
					
					
			//--------------------------------------------------------------------
			
			
			//EVENT HANDLER DEL BUTTON +
			buttonAdd.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					System.out.println("I'm inside the (+) handler");
					//tasto disabilitato causa errore
					if(isResetNeeded) {
						labelResult.setText("RESET FIRST");
					}
					//tasto funzionante
					else {
						//se NON esiste un primo operando OR ho già scelto un'altra operazione
						if(firstNumber==null || operation>0) {
							labelResult.setText("ERROR");
							isResetNeeded = true;
						}
						//esiste il primo operando AND devo ancora scegliere l'operazione
						else {
							operation = 1;
							labelResult.setText("+");
						}
					}
					
					
				}
			});
			
			//EVENT HANDLER DEL BUTTON -
			buttonSub.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					System.out.println("I'm inside the (-) handler");
					//tasto disabilitato causa errore
					if(isResetNeeded) {
						labelResult.setText("RESET FIRST");
					}
					//tasto funzionante
					else {
						//se NON esiste un primo operando OR ho già scelto un'altra operazione
						if(firstNumber==null || operation>0) {
							labelResult.setText("ERROR");
							isResetNeeded = true;
						}
						//esiste il primo operando AND devo ancora scegliere l'operazione
						else {
							operation = 2;
							labelResult.setText("-");
						}
					}
					
				}
			});
			
			//EVENT HANDLER DEL BUTTON *
			buttonMul.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					System.out.println("I'm inside the (*) handler");
					
					//tasto disabilitato causa errore
					if(isResetNeeded) {
						labelResult.setText("RESET FIRST");
					}
					//tasto funzionante
					else {
						//se NON esiste un primo operando OR ho già scelto un'altra operazione
						if(firstNumber==null || operation>0) {
							labelResult.setText("ERROR");
							isResetNeeded = true;
						}
						//esiste un primo operando AND devo ancora scegliere l'operazione
						else {
							operation = 3;
							labelResult.setText("*");
						}
					}
				}
			});
			
			//EVENT HANDLER DEL BUTTON /
			buttonDiv.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					System.out.println("I'm inside the (/) handler");
					//tasto disabilitato causa errore
					if(isResetNeeded) {
						labelResult.setText("RESET FIRST");
					}
					//tasto funzionante
					else {
						//se NON esiste un primo operando OR ho già scelto un'altra operazione
						if(firstNumber==null || operation>0) {
							labelResult.setText("ERROR");
							isResetNeeded = true;
						}
						//esiste un primo operando AND devo ancora scegliere l'operazione
						else {
							operation = 4;
							labelResult.setText("/");
						}
					}
					
				}
			});
			
			//EVENT HANDLER DEL BUTTON =
			buttonEq.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					System.out.println("I'm inside the (=) handler");
					//tasto disabilitato causa errore
					if(isResetNeeded) {
						labelResult.setText("RESET FIRST");
					}
					//tasto funzionante
					else {
						if(firstNumber==null || secondNumber==null) {
							labelResult.setText("SYNTAX ERROR");
							isResetNeeded = true;
						}
						else {
							switch(operation) {
							case -1:
								labelResult.setText("SYNTAX ERROR");
								isResetNeeded = true;
								break;
							case 0:
								labelResult.setText("SYNTAX ERROR");
								isResetNeeded = true;
								break;
							case 1:
								firstNumber = firstNumber + secondNumber;
								labelResult.setText(firstNumber.toString());
								break;
							case 2:
								firstNumber = firstNumber - secondNumber;
								labelResult.setText(firstNumber.toString());
								break;
							case 3:
								firstNumber = firstNumber * secondNumber;
								labelResult.setText(firstNumber.toString());
								break;
							case 4:
								if(secondNumber == 0) {
									labelResult.setText("MATH ERROR");
									isResetNeeded = true;
								}
								else {
									firstNumber = firstNumber / secondNumber;
									labelResult.setText(firstNumber.toString());
								}
								break;
							default:
								labelResult.setText("FATAL ERROR");
								isResetNeeded = true;
								break;
							}
						}
						operation = -1;
						secondNumber = null;
					}
				}
			});
			
			//EVENT HANDLER DEL BUTTON 0
			button0.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					System.out.println("I'm inside the (0) handler");
					//tasto disabilitato causa errore
					if(isResetNeeded) {
						labelResult.setText("RESET FIRST");
					}
					//tasto funzionante
					else {
						//sto inserendo il primo operando
						if(operation==0) {
							//non ho ancora inserito la prima cifra
							if(firstNumber==null) {
								firstNumber = 0.0;
							}
							//ho già inserito altre cifre
							else {
								firstNumber = (firstNumber*10)+0.0;
								
							}
							labelResult.setText(firstNumber.toString());
						}
						//avevo già il primo operando e dovevo inserire l'operazione
						if(operation == -1) {
							labelResult.setText("Error");
							isResetNeeded = true;
						}
						//ho già l'operazione(+,-,*,/), sto inserendo il secondo operando
						if(operation >= 1 && operation <=4){
							//non ho ancora inserito la prima cifra
							if(secondNumber==null) {
								secondNumber = 0.0;
							}
							//ho già inserito altre cifre
							else {
								secondNumber = (secondNumber*10)+0.0;
							}
							labelResult.setText(secondNumber.toString());
						}
					}
				}
			});
					
			//EVENT HANDLER DEL BUTTON 1
			button1.setOnAction(new EventHandler<ActionEvent>() {	
				public void handle(ActionEvent event) {
					System.out.println("I'm inside the (1) handler");
					//tasto disabilitato causa errore
					if(isResetNeeded) {
						labelResult.setText("RESET FIRST");
					}
					//tasto funzionante
					else {
						//sto inserendo il primo operando
						if(operation==0) {
							//non ho ancora inserito la prima cifra
							if(firstNumber==null) {
								firstNumber = 1.0;
							}
							//ho già inserito altre cifre
							else {
								firstNumber = (firstNumber*10)+1.0;
								
							}
							labelResult.setText(firstNumber.toString());
						}
						//avevo già il primo operando e dovevo inserire l'operazione
						if(operation == -1) {
							labelResult.setText("Error");
							isResetNeeded = true;
						}
						//ho già l'operazione(+,-,*,/), sto inserendo il secondo operando
						if(operation >= 1 && operation <=4){
							//non ho ancora inserito la prima cifra
							if(secondNumber==null) {
								secondNumber = 1.0;
							}
							//ho già inserito altre cifre
							else {
								secondNumber = (secondNumber*10)+1.0;
							}
							labelResult.setText(secondNumber.toString());
						}
					}
				}
			});
					
			//EVENT HANDLER DEL BUTTON 2
			button2.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					System.out.println("I'm inside the (2) handler");
					//tasto disabilitato causa errore
					if(isResetNeeded) {
						labelResult.setText("RESET FIRST");
					}
					//tasto funzionante
					else {
						//sto inserendo il primo operando
						if(operation==0) {
							//non ho ancora inserito la prima cifra
							if(firstNumber==null) {
								firstNumber = 2.0;
							}
							//ho già inserito altre cifre
							else {
								firstNumber = (firstNumber*10)+2.0;
								
							}
							labelResult.setText(firstNumber.toString());
						}
						//avevo già il primo operando e dovevo inserire l'operazione
						if(operation == -1) {
							labelResult.setText("Error");
							isResetNeeded = true;
						}
						//ho già l'operazione(+,-,*,/), sto inserendo il secondo operando
						if(operation >= 1 && operation <=4){
							//non ho ancora inserito la prima cifra
							if(secondNumber==null) {
								secondNumber = 2.0;
							}
							//ho già inserito altre cifre
							else {
								secondNumber = (secondNumber*10)+2.0;
							}
							labelResult.setText(secondNumber.toString());
						}
					}
				}
			});
					
			//EVENT HANDLER DEL BUTTON 3
			button3.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					System.out.println("I'm inside the (3) handler");
					//tasto disabilitato causa errore
					if(isResetNeeded) {
						labelResult.setText("RESET FIRST");
					}
					//tasto funzionante
					else {
						//sto inserendo il primo operando
						if(operation==0) {
							//non ho ancora inserito la prima cifra
							if(firstNumber==null) {
								firstNumber = 3.0;
							}
							//ho già inserito altre cifre
							else {
								firstNumber = (firstNumber*10)+3.0;
								
							}
							labelResult.setText(firstNumber.toString());
						}
						//avevo già il primo operando e dovevo inserire l'operazione
						if(operation == -1) {
							labelResult.setText("Error");
							isResetNeeded = true;
						}
						//ho già l'operazione(+,-,*,/), sto inserendo il secondo operando
						if(operation >= 1 && operation <=4){
							//non ho ancora inserito la prima cifra
							if(secondNumber==null) {
								secondNumber = 3.0;
							}
							//ho già inserito altre cifre
							else {
								secondNumber = (secondNumber*10)+3.0;
							}
							labelResult.setText(secondNumber.toString());
						}
					}
				}
			});
					
			//EVENT HANDLER DEL BUTTON 4
			button4.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					System.out.println("I'm inside the (4) handler");
					//tasto disabilitato causa errore
					if(isResetNeeded) {
						labelResult.setText("RESET FIRST");
					}
					//tasto funzionante
					else {
						//sto inserendo il primo operando
						if(operation==0) {
							//non ho ancora inserito la prima cifra
							if(firstNumber==null) {
								firstNumber = 4.0;
							}
							//ho già inserito altre cifre
							else {
								firstNumber = (firstNumber*10)+4.0;
								
							}
							labelResult.setText(firstNumber.toString());
						}
						//avevo già il primo operando e dovevo inserire l'operazione
						if(operation == -1) {
							labelResult.setText("Error");
							isResetNeeded = true;
						}
						//ho già l'operazione(+,-,*,/), sto inserendo il secondo operando
						if(operation >= 1 && operation <=4){
							//non ho ancora inserito la prima cifra
							if(secondNumber==null) {
								secondNumber = 4.0;
							}
							//ho già inserito altre cifre
							else {
								secondNumber = (secondNumber*10)+4.0;
							}
							labelResult.setText(secondNumber.toString());
						}
					}
				}
			});
					
			//EVENT HANDLER DEL BUTTON 5
			button5.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					System.out.println("I'm inside the (5) handler");
					//tasto disabilitato causa errore
					if(isResetNeeded) {
						labelResult.setText("RESET FIRST");
					}
					//tasto funzionante
					else {
						//sto inserendo il primo operando
						if(operation==0) {
							//non ho ancora inserito la prima cifra
							if(firstNumber==null) {
								firstNumber = 5.0;
							}
							//ho già inserito altre cifre
							else {
								firstNumber = (firstNumber*10)+5.0;
								
							}
							labelResult.setText(firstNumber.toString());
						}
						//avevo già il primo operando e dovevo inserire l'operazione
						if(operation == -1) {
							labelResult.setText("Error");
							isResetNeeded = true;
						}
						//ho già l'operazione(+,-,*,/), sto inserendo il secondo operando
						if(operation >= 1 && operation <=4){
							//non ho ancora inserito la prima cifra
							if(secondNumber==null) {
								secondNumber = 5.0;
							}
							//ho già inserito altre cifre
							else {
								secondNumber = (secondNumber*10)+5.0;
							}
							labelResult.setText(secondNumber.toString());
						}
					}
				}
			});
					
			//EVENT HANDLER DEL BUTTON 6
			button6.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					System.out.println("I'm inside the (6) handler");
					//tasto disabilitato causa errore
					if(isResetNeeded) {
						labelResult.setText("RESET FIRST");
					}
					//tasto funzionante
					else {
						//sto inserendo il primo operando
						if(operation==0) {
							//non ho ancora inserito la prima cifra
							if(firstNumber==null) {
								firstNumber = 6.0;
							}
							//ho già inserito altre cifre
							else {
								firstNumber = (firstNumber*10)+6.0;
								
							}
							labelResult.setText(firstNumber.toString());
						}
						//avevo già il primo operando e dovevo inserire l'operazione
						if(operation == -1) {
							labelResult.setText("Error");
							isResetNeeded = true;
						}
						//ho già l'operazione(+,-,*,/), sto inserendo il secondo operando
						if(operation >= 1 && operation <=4){
							//non ho ancora inserito la prima cifra
							if(secondNumber==null) {
								secondNumber = 6.0;
							}
							//ho già inserito altre cifre
							else {
								secondNumber = (secondNumber*10)+6.0;
							}
							labelResult.setText(secondNumber.toString());
						}
					}
				}
			});
					
			//EVENT HANDLER DEL BUTTON 7
			button7.setOnAction(new EventHandler<ActionEvent>() {			
				public void handle(ActionEvent event) {
					System.out.println("I'm inside the (7) handler");
					//tasto disabilitato causa errore
					if(isResetNeeded) {
						labelResult.setText("RESET FIRST");
					}
					//tasto funzionante
					else {
						//sto inserendo il primo operando
						if(operation==0) {
							//non ho ancora inserito la prima cifra
							if(firstNumber==null) {
								firstNumber = 7.0;
							}
							//ho già inserito altre cifre
							else {
								firstNumber = (firstNumber*10)+7.0;
								
							}
							labelResult.setText(firstNumber.toString());
						}
						//avevo già il primo operando e dovevo inserire l'operazione
						if(operation == -1) {
							labelResult.setText("Error");
							isResetNeeded = true;
						}
						//ho già l'operazione(+,-,*,/), sto inserendo il secondo operando
						if(operation >= 1 && operation <=4){
							//non ho ancora inserito la prima cifra
							if(secondNumber==null) {
								secondNumber = 7.0;
							}
							//ho già inserito altre cifre
							else {
								secondNumber = (secondNumber*10)+7.0;
							}
							labelResult.setText(secondNumber.toString());
						}
					}
				}
			});
					
			//EVENT HANDLER DEL BUTTON 8
			button8.setOnAction(new EventHandler<ActionEvent>() {			
				public void handle(ActionEvent event) {
					System.out.println("I'm inside the (8) handler");
					//tasto disabilitato causa errore
					if(isResetNeeded) {
						labelResult.setText("RESET FIRST");
					}
					//tasto funzionante
					else {
						//sto inserendo il primo operando
						if(operation==0) {
							//non ho ancora inserito la prima cifra
							if(firstNumber==null) {
								firstNumber = 8.0;
							}
							//ho già inserito altre cifre
							else {
								firstNumber = (firstNumber*10)+8.0;
								
							}
							labelResult.setText(firstNumber.toString());
						}
						//avevo già il primo operando e dovevo inserire l'operazione
						if(operation == -1) {
							labelResult.setText("Error");
							isResetNeeded = true;
						}
						//ho già l'operazione(+,-,*,/), sto inserendo il secondo operando
						if(operation >= 1 && operation <=4){
							//non ho ancora inserito la prima cifra
							if(secondNumber==null) {
								secondNumber = 8.0;
							}
							//ho già inserito altre cifre
							else {
								secondNumber = (secondNumber*10)+8.0;
							}
							labelResult.setText(secondNumber.toString());
						}
					}
				}
			});
					
			//EVENT HANDLER DEL BUTTON 9
			button9.setOnAction(new EventHandler<ActionEvent>() {		
				public void handle(ActionEvent event) {
					System.out.println("I'm inside the (9) handler");
					//tasto disabilitato causa errore
					if(isResetNeeded) {
						labelResult.setText("RESET FIRST");
					}
					//tasto funzionante
					else {
						//sto inserendo il primo operando
						if(operation==0) {
							//non ho ancora inserito la prima cifra
							if(firstNumber==null) {
								firstNumber = 9.0;
							}
							//ho già inserito altre cifre
							else {
								firstNumber = (firstNumber*10)+9.0;
								
							}
							labelResult.setText(firstNumber.toString());
						}
						//avevo già il primo operando e dovevo inserire l'operazione
						if(operation == -1) {
							labelResult.setText("Error");
							isResetNeeded = true;
						}
						//ho già l'operazione(+,-,*,/), sto inserendo il secondo operando
						if(operation >= 1 && operation <=4){
							//non ho ancora inserito la prima cifra
							if(secondNumber==null) {
								secondNumber = 9.0;
							}
							//ho già inserito altre cifre
							else {
								secondNumber = (secondNumber*10)+9.0;
							}
							labelResult.setText(secondNumber.toString());
						}
					}
				}
			});
			
			//EVENT HANDLER DEL BUTTON CANCEL
			buttonCancel.setOnAction(new EventHandler<ActionEvent>() {		
				public void handle(ActionEvent event) {
					System.out.println("I'm inside the (cancel) handler");
					//tasto disabilitato causa errore
					if(isResetNeeded) {
						labelResult.setText("RESET FIRST");
					}
					//tasto funzionante
					else {
						//se il primo operando NON esiste
						if(firstNumber==null) {
							//non fare nulla
						}
						//se ALMENO il primo operando esiste
						else {
							//se sto attualmente lavorando al primo operando
							if(secondNumber==null && operation<=0) {
								//se ho ottenuto il primo operando come risultato di una precedente operazione
								if(operation==-1) {
									//non fare nulla
								}
								//se ho scritto manualmente il primo operando
								else {
									Double tempLastDigit;
									tempLastDigit = firstNumber%10;
									firstNumber = (firstNumber-tempLastDigit)/10;
									labelResult.setText(firstNumber.toString());
								}
								
							}
							//se sto attualmente lavorando al secondo operando
							else {
								//(il secondo operando non esiste (se ho premuto il tasto canc subito dopo aver premuto il tasto di un'operazione)
								if(secondNumber==null) {
									//non fare nulla
								}
								//un secondo operando esiste e sto lavorando su di lui
								else {
									Double tempLastDigit;
									tempLastDigit = secondNumber%10;
									secondNumber = (secondNumber-tempLastDigit)/10;
									labelResult.setText(secondNumber.toString());
								}
							}
						}
					}
				}
			});
			
			//EVENT HANDLER DEL BUTTON CANCEL ALL (RESET)
			buttonCancelAll.setOnAction(new EventHandler<ActionEvent>() {		
				public void handle(ActionEvent event) {
					System.out.println("I'm inside the (reset) handler");
					firstNumber=null;
					secondNumber=null;
					operation=0;
					labelResult.setText("Waiting Input...");
					isResetNeeded = false;
					
				}
			});
					
			// <> <> <> <> <> <> <> <> <> <> <> <> <> <> <> <> <> <> <> <> <> <> <> <> <>
			
			//>>>> IMPOSTA LA STRUTTURA DEGLI ELEMENTI
			row1.getChildren().addAll(labelResult);
			row2.getChildren().addAll(buttonCancelAll,buttonCancel);
			row3.getChildren().addAll(buttonPlaceHolder1,buttonPlaceHolder2,buttonPlaceHolder3,buttonDiv);
			row4.getChildren().addAll(button7,button8,button9,buttonMul);
			row5.getChildren().addAll(button4,button5,button6,buttonSub);
			row6.getChildren().addAll(button1,button2,button3,buttonAdd);
			row7.getChildren().addAll(buttonPlaceHolder4,button0,buttonPlaceHolder5,buttonEq);

			root.getChildren().addAll(row1,row2,row3,row4,row5,row6,row7);
			
			//mostra lo stage creato
			primaryStage.show();
		}
}
