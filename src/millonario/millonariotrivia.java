package millonario;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import com.sun.javafx.animation.TickCalculation;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class millonariotrivia extends Application {
	
	private static final Font FONT = Font.font(18);
	
	private QuestionPane qPane = new QuestionPane();
	
	private SidePane sPane = new SidePane();
	
	Stage Ventana;
	
	private int pinco = 1;
	private int np = 1;
	
	private ArrayList<Question> cuestionario = new ArrayList<Question>();
	
	private Parent crearFinal() {
		VBox root = new VBox();
		HBox botones = new HBox();
		Label t = new Label("         Gracias por participar:");
		t.setFont(FONT);
		t.setTextFill(Color.BLACK);
		Label t1 = new Label("         Cometiste: " + pinco + " errores");
		t1.setFont(FONT);
		t1.setTextFill(Color.BLACK);
		try {
			FileInputStream input = new FileInputStream("src/sepbot.png");
			Image imagen = new Image(input);
			ImageView iv = new ImageView(imagen);
			botones.getChildren().add(iv);
		} catch (FileNotFoundException e) {
			System.out.println("NO SE ENCONTRO LA IMAGEN");
			e.printStackTrace();
		}
		Button brep = new Button("Jugar de nuevo");
		Button salir = new Button("Salir");
		salir.setOnAction(cerrrar -> {
			Ventana.close();
		});
		brep.setOnAction(o -> {
			Scene sc = new Scene(crearInicio());
		sc.getStylesheets().add("css/estilos.css");
		Ventana.setScene(sc);
		Ventana.setTitle("Aprendiendo Logica");
		Ventana.show();
		sc.getRoot().requestFocus();
		}
				);
		root.setStyle("-fx-background-color: #d7f0f7");
		HBox.setMargin(botones, new Insets(20,20,20,20) );
		botones.setSpacing(30);
		botones.getChildren().addAll(brep, salir);
		root.setPrefSize(300, 100);
		root.getChildren().addAll(t,t1,botones);
		return root;
	}
	
	private Parent crearInicio() {
		VBox root = new VBox();
		HBox texto = new HBox();
		Label ti = new Label("Bienvenido, ingresa tu nombre para empezar: ");
		ti.setFont(FONT);
		ti.setAlignment(Pos.CENTER);
		TextField nom = new TextField();
		nom.setAlignment(Pos.CENTER);
		Button b = new Button("Jugar!");
		b.setOnAction(e -> {
			Scene sc = new Scene(createContent());
			sc.getStylesheets().add("css/estilos.css");
			Ventana.setScene(sc);
			Ventana.setTitle("Aprendiendo Logica");
			Ventana.show();
			sc.getRoot().requestFocus();
		});
		b.setAlignment(Pos.CENTER);
		root.setStyle("-fx-background-color: #d7f0f7");
		root.setSpacing(12);
		try {
			FileInputStream input = new FileInputStream("src/sepboton.png");
			Image imagen = new Image(input);
			ImageView iv = new ImageView(imagen);
			texto.getChildren().add(iv);
		} catch (FileNotFoundException e) {
			System.out.println("NO SE ENCONTRO LA IMAGEN");
			e.printStackTrace();
		}
		texto.getChildren().add(b);
		root.getChildren().addAll(ti,nom,texto);
		root.setPrefSize(380, 115);
		return root;
	}
	private Parent createContent()  {
		HBox root = new HBox();
		VBox separador = new VBox();
		VBox separador3 = new VBox();
		VBox separador2 = new VBox();
		try {
			FileInputStream input = new FileInputStream("src/imgp.jpg");
			Image imagen = new Image(input);
			ImageView iv = new ImageView(imagen);
			separador.getChildren().add(iv);
		} catch (FileNotFoundException e) {
			System.out.println("NO SE ENCONTRO LA IMAGEN");
			e.printStackTrace();
		}
		
		try {
			FileInputStream input3 = new FileInputStream("src/blanc2.png");
			Image imagen3 = new Image(input3);
			ImageView iv3 = new ImageView(imagen3);
			separador3.getChildren().add(iv3);
		} catch (FileNotFoundException e) {
			System.out.println("NO SE ENCONTRO LA IMAGEN");
			e.printStackTrace();
		}
		try {
			FileInputStream input2 = new FileInputStream("src/sep.png");
			Image imagen2 = new Image(input2);
			ImageView iv2 = new ImageView(imagen2);
			separador2.getChildren().add(iv2);
		} catch (FileNotFoundException e) {
			System.out.println("NO SE ENCONTRO LA IMAGEN");
			e.printStackTrace();
		}
		root.setPrefSize(800, 250);
		Random rand = new Random();
		cuestionario.add(new Question("Cual seria una interpretacion de P(x)={x|¬ x<=8}","x es mayor que 8","x es 8","x es menor que 8","x es menor igual que 8"));
		cuestionario.add(new Question("La implicacion no es...","Simetrica","Idempotente","Conmutativa","Asociativa"));
		cuestionario.add(new Question("Que no forma parte de la proposicion condicional","antecedente","consecuente","si... entonces","Ninguna de las anteriores"));
		cuestionario.add(new Question("Cual no es una forma Modus de inferencia logica","Modus Morgan Ponen","Modus Ponendo Ponens","Modus Tollendo Tollens","Modus Tollendo Ponens"));
		cuestionario.add(new Question("Cual no es una Regla de inferencia logica","Regla del Dilema Hipotetico","Regla de simplificación","Regla de adición","Regla de silogismo hipotético"));
		cuestionario.add(new Question("Que no forma parte de la deduccion logica","Negacion","Premisas","Consecuente","Reglas de Inferencias"));
		cuestionario.add(new Question("Que no carateriza al cuantificador existencial","tal vez","para algun","existe un","existe al menos un"));
		cuestionario.add(new Question("Cual no es un tipo de demostracion","validacion","contrajemplo","contradiccion","reducción al absurdo"));
		cuestionario.add(new Question("Que es verdad sobre el razonamiento deductivo","consta de hipotesis y conclusiones","no sirve con variables proposicionales", "es una forma de demostracion directa", "solo puede ser verdadero o falso"));
		cuestionario.add(new Question("La induccion matematica primero prueba si funciona para:","el primer termino", "el caso x", "todos los casos", "el termino n"));
		cuestionario.add(new Question("El principio del buen orden solo existe ...", "es universal en las matematicas", "solo en los numero reales", "no existe en los numeros irracionales", "en casos de conjuntos finitos"));
		cuestionario.add(new Question("La logica no ...", "se centra en el significado del enunciado", "estudia el razonamiento", "se centra en las relaciones de los enunciados","analiza si un razonamiento es correcto"));
		cuestionario.add(new Question("Un razonamiento puede ser:", "correcto", "verdadero o falso","real","complejo o simple"));
		cuestionario.add(new Question("Una proposicion es...", "verdadera o falsa", "es verdadera", "es falsa", "es ambigua"));
		cuestionario.add(new Question("Los conectores...","sirven para conectar variables proposicionales","solo conectan variables del mismo valor", "crena proposiciones simples","se usan solo para definir dominios"));
		cuestionario.add(new Question("Una condicional p->q es falsa si","p=1 q=0","p=q=0","p=q","p=0 q=1"));
		cuestionario.add(new Question("Si la primera parte de la condicional es falsa...","la proposicion siempre sera verdadera","la proposicion solo puede tomar un solo valor en la consecuente","el consencuente es falso","el consencuente es falso"));
		cuestionario.add(new Question("El bicondicional...","es falso si ambos son diferentes","es verdadero si ambas partes son falsas","es verdadero si ambos son verdaderos", "es falso si ambos son falsos"));
		root.setStyle("-fx-background-color: #d7f0f7");
		root.getChildren().add(separador);
		qPane.setQuestion(cuestionario.get(0));
		root.getChildren().addAll(qPane, separador3 ,separador2, sPane);
		
		
		return root;
	}
	
	
	private void nextQuestion() {
		Random rand = new Random();
		qPane.setQuestion(cuestionario.get(np));
		sPane.selectNext();
		np +=1;
	}
	
	private class SidePane extends VBox {
		
		private int current = 1;
		public SidePane() {
			super(2);
			
			for(int i = 15; i > 0; i--) {
				Text text = new Text("Pregunta " + i );
				text.setFill(i == current ? Color.BLACK : Color.GRAY);
				setAlignment(Pos.CENTER_RIGHT);
				getChildren().add(text);
					}
			
		}
		public void selectNext() {
			if (current == 15) {
				current = 1;
				return;
			}
			
			Text text = (Text)getChildren().get(15 - current);
			text.setFill(Color.GRAY);
			current++;
			text = (Text)getChildren().get(15 - current);
			text.setFill(Color.BLACK);
		}
	}
	
	private class QuestionPane extends VBox {
		private Text text = new Text();
		private List<Button> buttons = new ArrayList<>();
		private Question current;
	
		
		public QuestionPane() {
			
			
			try {
				FileInputStream input4 = new FileInputStream("src/qsep.png");
				Image imagen4 = new Image(input4);
				ImageView iv4 = new ImageView(imagen4);
				getChildren().add(iv4);
			} catch (FileNotFoundException e) {
				System.out.println("NO SE ENCONTRO LA IMAGEN");
				e.printStackTrace();
			}
			text.setFont(FONT);
			VBox hbox = new VBox();
			hbox.setSpacing(7);
			for (int i = 0; i < 4; i++) {
				Button btn = new Button();
				btn.setFont(FONT);
				btn.setPrefWidth(350);
				btn.setOnAction(event -> {
					if (btn.getText().equals(current.getCorrectAnswer())) {
						if(current.equals(cuestionario.get(14))) {
							Scene sc = new Scene(crearFinal());
							sc.getStylesheets().add("css/estilos.css");
							Ventana.setScene(sc);
							Ventana.setTitle("Aprendiendo Logica");
							Ventana.show();
							sc.getRoot().requestFocus();
							
						}
						nextQuestion();
					}else {
						Alert a = new Alert(AlertType.ERROR);
						a.setContentText("Mala suerte, vuelve a intentarlo");
						a.show();
						pinco += 1;
					}
				});
				
				buttons.add(btn);
				hbox.getChildren().add(btn);
			}
			setAlignment(Pos.TOP_LEFT);
			getChildren().addAll(text, hbox);
		}
		public void setQuestion(Question question) {
			current = question;
			text.setText(question.name);
			
			Collections.shuffle(buttons);
			for(int i = 0; i < 4; i++) {
				buttons.get(i).setText(question.answers.get(i));
				
			}
		}
		
	}
	
	private class Question {
		private String name;
		private List<String> answers;
		
		public Question(String name, String... answers) {
			this.name = name;
			this.answers = Arrays.asList(answers);
		}
		
		public String getCorrectAnswer() {
			return answers.get(0);
		}
	}
	@Override
	public void start(Stage primaryStage) throws Exception{
		Ventana = primaryStage;
		Scene sc = new Scene(crearInicio());
		sc.getStylesheets().add("css/estilos.css");
		primaryStage.setScene(sc);
		primaryStage.setTitle("Aprendiendo Logica");
		primaryStage.show();
		sc.getRoot().requestFocus();
		
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
