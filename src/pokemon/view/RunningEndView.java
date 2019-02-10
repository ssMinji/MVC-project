package pokemon.view;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import pokemon.model.dto.DoctorDTO;
import pokemon.model.dto.HospitalDTO;
import pokemon.model.dto.PokemonDTO;
import pokemon.model.dto.TrainerDTO;

public class RunningEndView {

	public static void allDoctorDataPrint(ArrayList<DoctorDTO> allDoctor) {
		for(DoctorDTO dto : allDoctor) {
			System.out.println(dto);
		}
	}
	
	public static void doctorView(DoctorDTO doctor) {
		System.out.println(doctor);
	}
	
	public static void allTrainerDataPrint(ArrayList<TrainerDTO> allTrainer) {
		for(TrainerDTO dto : allTrainer) {
			System.out.println(dto);
		}
	}
	public static void allHospitalDataPrint(ArrayList<HospitalDTO> allHospital) {
		for(HospitalDTO dto : allHospital) {
			System.out.println(dto);
		}
	}
	
	public static void trainerView(TrainerDTO trainer) {
		System.out.println(trainer);
	}
	
	public static void pokemonView(PokemonDTO pokemon) {
		System.out.println(pokemon);
	}
	public static void hospitalView(HospitalDTO hospital) {
		System.out.println(hospital);
	}

	public static void showSuccessView(String message) {
		System.out.println("정상 실행 : " + message);
	}

	public static void showError(String message) {
		System.out.println("에러 발생 : " + message);
	}
	
	 public static void imageView(PokemonDTO pokemon) {
	      BufferedImage img = null;
	      String str = "C:\\0.ITStudy\\2.JAVA\\mini_project\\img\\" + pokemon.getId()+".PNG";
	      try {
	         File sourceimage = new File(str);
	         img = ImageIO.read(sourceimage);
	      } catch (IOException e) {
	         e.printStackTrace();
	      }
	      JFrame frame = new JFrame("★★★★★포켓몬 검색 결과★★★★★");
	        frame.setSize(500, 500);
	        JLabel label = new JLabel(new ImageIcon(img));
	        frame.add(label);
	        frame.setVisible(true);
	   }
}
