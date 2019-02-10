package pokemon.service;

import java.sql.SQLException;
import java.util.ArrayList;
import pokemon.model.DoctorDAO;
import pokemon.model.HospitalDAO;
import pokemon.model.PokemonDAO;
import pokemon.model.TrainerDAO;
import pokemon.model.dto.DoctorDTO;
import pokemon.model.dto.HospitalDTO;
import pokemon.model.dto.PokemonDTO;
import pokemon.model.dto.TrainerDTO;
import pokemon.view.RunningEndView;

public class HospitalRecordController {
	private static HospitalRecordController instance = new HospitalRecordController();

	private HospitalRecordController() {
	}

	public static HospitalRecordController getInstance() {
		return instance;
	}

	// 모든 Doctor 검색 로직
	public static void getAllDoctors() {
		ArrayList<DoctorDTO> allDoctor = null;
		try {
			allDoctor = DoctorDAO.getAllDoctor();
			if (allDoctor.size() != 0) {
				RunningEndView.allDoctorDataPrint(allDoctor);
			} else {
				RunningEndView.showSuccessView("고객님께서 요청하신 데이터는 존재하지 않습니다");
			}
		} catch (SQLException s) {
			s.printStackTrace();
			RunningEndView.showError("의사 검색시 에러 발생");
		}
	}

	// ID로 Doctor 정보 검색
	public static void getDoctor(int id) {
		DoctorDTO doctor = null;
		try {
			doctor = DoctorDAO.getDoctor(id);
			if (doctor != null) {
				RunningEndView.doctorView(doctor);
			} else {
				RunningEndView.showSuccessView("고객님께서 입력하신 ID를 가진 의사는 존재하지 않습니다");
			}
		} catch (SQLException s) {
			s.printStackTrace();
			RunningEndView.showError("입력하신 ID 검색시 에러 발생");
		}
	}

	// Major로 Doctor 정보 삭제
	public static void deleteDoctor(String major) {
		try {
			boolean result = DoctorDAO.deleteDoctor(major);
			if (result = true) {
				RunningEndView.showSuccessView("고객님께서 입력하신 전공 담당의가 삭제되었습니다");
			} else {
				RunningEndView.showSuccessView("고객님께서 입력하신 전공의 담당의는 존재하지 않습니다");
			}
		} catch (SQLException s) {
			s.printStackTrace();
			RunningEndView.showError("입력하신 전공 검색시 에러 발생");
		}
	}

	// ID로 Doctor Major 변경
	public static void updateDoctor(int id, String major) {
		try {
			boolean result = DoctorDAO.updateDoctor(id, major);
			if (result = true) {
				RunningEndView.showSuccessView("고객님께서 입력하신 ID의 담당의의 전공이 변경되었습니다");
			} else {
				RunningEndView.showSuccessView("고객님께서 입력하신 ID의 담당의는 존재하지 않습니다");
			}
		} catch (SQLException s) {
			s.printStackTrace();
			RunningEndView.showError("입력하신 ID로 수정 시도시 에러 발생");
		}
	}

	// 모든 Trainer 검색 로직
	public static void getAllTrainers() {
		ArrayList<TrainerDTO> allTrainer = null;
		try {
			allTrainer = TrainerDAO.getAllTrainer();
			if (allTrainer.size() != 0) {
				RunningEndView.allTrainerDataPrint(allTrainer);
			} else {
				RunningEndView.showSuccessView("고객님께서 요청하신 데이터는 존재하지 않습니다");
			}
		} catch (SQLException s) {
			s.printStackTrace();
			RunningEndView.showError("보호자 검색시 에러 발생");
		}
	}

	// 새로운 Trainer 등록
	public static void addTrainerReqRes(int id, String name, int age, String gender, String region, String pokemon1,
			String pokemon2, String pokemon3, String pokemon4) {
		try {
			boolean result = TrainerDAO
					.addTrainer(new TrainerDTO(id, name, age, gender, region, pokemon1, pokemon2, pokemon3, pokemon4));
			if (result = true) {
				RunningEndView.showSuccessView("입력하신 보호자의 정보가 성공적으로 입력되었습니다");
			} else {
				RunningEndView.showSuccessView("입력하신 보호자의 정보 입력에 실패하였습니다");
			}
		} catch (SQLException s) {
			s.printStackTrace();
			RunningEndView.showError("보호자 정보 저장시 에러 발생");
		}
	}

	// ID로 Trainer 정보 검색
	public static void getTrainer(String id) {
		TrainerDTO trainer = null;
		try {
			trainer = TrainerDAO.getTrainer(id);
			if (trainer != null) {
				RunningEndView.trainerView(trainer);
			} else {
				RunningEndView.showSuccessView("고객님께서 입력하신 ID를 가진 보호자는 존재하지 않습니다");
			}
		} catch (SQLException s) {
			s.printStackTrace();
			RunningEndView.showError("입력하신 ID 검색시 에러 발생");
		}
	}

	// ID로 Trainer 정보 삭제
	public static void deleteTrainer(int id) {
		try {
			boolean result = TrainerDAO.deleteTrainer(id);
			if (result == true) {
				RunningEndView.showSuccessView("고객님께서 입력하신 ID를 가진 보호자가 삭제되었습니다");
			} else {
				RunningEndView.showSuccessView("고객님께서 입력하신 ID를 가진 보호자는 존재하지 않습니다");
			}
		} catch (SQLException s) {
			s.printStackTrace();
			RunningEndView.showError("입력하신 ID 검색시 에러 발생");
		}
	}

	// ID로 Pokemon 정보 검색
	public static void getPokemon(int id) {
		PokemonDTO pokemon = null;
		try {
			pokemon = PokemonDAO.getPokemon(id);
			if (pokemon != null) {
				RunningEndView.pokemonView(pokemon);
				RunningEndView.imageView(pokemon);
			} else {
				RunningEndView.showSuccessView("고객님께서 입력하신 ID를 가진 포켓몬은 존재하지 않습니다");
			}
		} catch (SQLException s) {
			s.printStackTrace();
			RunningEndView.showError("입력하신 ID 검색시 에러 발생");
		}
	}

	// Pokemon id로 입원기록 조회
	public static void getHospital(int pid) {
		HospitalDTO hospital = null;
		try {
			hospital = HospitalDAO.getHospital(pid);
			if (hospital != null) {
				RunningEndView.hospitalView(hospital);
			} else {
				RunningEndView.showSuccessView("고객님께서 입력하신 포켓몬 이름을 가진 환자는 존재하지 않습니다");
			}
		} catch (SQLException s) {
			s.printStackTrace();
			RunningEndView.showError("입력하신 이름의 포켓몬 환자 검색시 에러 발생");
		}
	}

	// 모든 환자 입원 현황 로직
	public static void getAllHospital() {
		ArrayList<HospitalDTO> allHospital = null;
		try {
			allHospital = HospitalDAO.getAllHospital();
			if (allHospital.size() != 0) {
				RunningEndView.allHospitalDataPrint(allHospital);
			} else {
				RunningEndView.showSuccessView("고객님께서 요청하신 데이터는 존재하지 않습니다");
			}
		} catch (SQLException s) {
			s.printStackTrace();
			RunningEndView.showError("입원현황 검색시 에러 발생");
		}
	}

	// 새로운 Hospital 등록
	public static void addHospitalReqRes(int no, int did, int tid, int pid, String indate, String outdate) {
		try {
			boolean result = HospitalDAO.addHospital(new HospitalDTO(no, did, tid, pid, indate, outdate));
			if (result = true) {
				RunningEndView.showSuccessView("입력하신 정보가 입원 장부에 성공적으로 입력되었습니다");
			} else {
				RunningEndView.showSuccessView("입력하신 정보를 입원 장부에 입력하는데 실패했습니다");
			}
		} catch (SQLException s) {
			s.printStackTrace();
			RunningEndView.showError("입원 장부 저장시 에러 발생");
		}
	}

	// 입원현황 갱신
	public static void refreshHospital() {
		try {
			boolean result = HospitalDAO.refreshHospital();
			if (result != true) {
				RunningEndView.showSuccessView("입원 현황 갱신을 완료하였습니다.");
			} else {
				RunningEndView.showSuccessView("입원 현황 갱신 상에 문제가 발생했습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			RunningEndView.showError("입원 현황 갱신 에러 발생");
		}
	}
}
