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

	// ��� Doctor �˻� ����
	public static void getAllDoctors() {
		ArrayList<DoctorDTO> allDoctor = null;
		try {
			allDoctor = DoctorDAO.getAllDoctor();
			if (allDoctor.size() != 0) {
				RunningEndView.allDoctorDataPrint(allDoctor);
			} else {
				RunningEndView.showSuccessView("���Բ��� ��û�Ͻ� �����ʹ� �������� �ʽ��ϴ�");
			}
		} catch (SQLException s) {
			s.printStackTrace();
			RunningEndView.showError("�ǻ� �˻��� ���� �߻�");
		}
	}

	// ID�� Doctor ���� �˻�
	public static void getDoctor(int id) {
		DoctorDTO doctor = null;
		try {
			doctor = DoctorDAO.getDoctor(id);
			if (doctor != null) {
				RunningEndView.doctorView(doctor);
			} else {
				RunningEndView.showSuccessView("���Բ��� �Է��Ͻ� ID�� ���� �ǻ�� �������� �ʽ��ϴ�");
			}
		} catch (SQLException s) {
			s.printStackTrace();
			RunningEndView.showError("�Է��Ͻ� ID �˻��� ���� �߻�");
		}
	}

	// Major�� Doctor ���� ����
	public static void deleteDoctor(String major) {
		try {
			boolean result = DoctorDAO.deleteDoctor(major);
			if (result = true) {
				RunningEndView.showSuccessView("���Բ��� �Է��Ͻ� ���� ����ǰ� �����Ǿ����ϴ�");
			} else {
				RunningEndView.showSuccessView("���Բ��� �Է��Ͻ� ������ ����Ǵ� �������� �ʽ��ϴ�");
			}
		} catch (SQLException s) {
			s.printStackTrace();
			RunningEndView.showError("�Է��Ͻ� ���� �˻��� ���� �߻�");
		}
	}

	// ID�� Doctor Major ����
	public static void updateDoctor(int id, String major) {
		try {
			boolean result = DoctorDAO.updateDoctor(id, major);
			if (result = true) {
				RunningEndView.showSuccessView("���Բ��� �Է��Ͻ� ID�� ������� ������ ����Ǿ����ϴ�");
			} else {
				RunningEndView.showSuccessView("���Բ��� �Է��Ͻ� ID�� ����Ǵ� �������� �ʽ��ϴ�");
			}
		} catch (SQLException s) {
			s.printStackTrace();
			RunningEndView.showError("�Է��Ͻ� ID�� ���� �õ��� ���� �߻�");
		}
	}

	// ��� Trainer �˻� ����
	public static void getAllTrainers() {
		ArrayList<TrainerDTO> allTrainer = null;
		try {
			allTrainer = TrainerDAO.getAllTrainer();
			if (allTrainer.size() != 0) {
				RunningEndView.allTrainerDataPrint(allTrainer);
			} else {
				RunningEndView.showSuccessView("���Բ��� ��û�Ͻ� �����ʹ� �������� �ʽ��ϴ�");
			}
		} catch (SQLException s) {
			s.printStackTrace();
			RunningEndView.showError("��ȣ�� �˻��� ���� �߻�");
		}
	}

	// ���ο� Trainer ���
	public static void addTrainerReqRes(int id, String name, int age, String gender, String region, String pokemon1,
			String pokemon2, String pokemon3, String pokemon4) {
		try {
			boolean result = TrainerDAO
					.addTrainer(new TrainerDTO(id, name, age, gender, region, pokemon1, pokemon2, pokemon3, pokemon4));
			if (result = true) {
				RunningEndView.showSuccessView("�Է��Ͻ� ��ȣ���� ������ ���������� �ԷµǾ����ϴ�");
			} else {
				RunningEndView.showSuccessView("�Է��Ͻ� ��ȣ���� ���� �Է¿� �����Ͽ����ϴ�");
			}
		} catch (SQLException s) {
			s.printStackTrace();
			RunningEndView.showError("��ȣ�� ���� ����� ���� �߻�");
		}
	}

	// ID�� Trainer ���� �˻�
	public static void getTrainer(String id) {
		TrainerDTO trainer = null;
		try {
			trainer = TrainerDAO.getTrainer(id);
			if (trainer != null) {
				RunningEndView.trainerView(trainer);
			} else {
				RunningEndView.showSuccessView("���Բ��� �Է��Ͻ� ID�� ���� ��ȣ�ڴ� �������� �ʽ��ϴ�");
			}
		} catch (SQLException s) {
			s.printStackTrace();
			RunningEndView.showError("�Է��Ͻ� ID �˻��� ���� �߻�");
		}
	}

	// ID�� Trainer ���� ����
	public static void deleteTrainer(int id) {
		try {
			boolean result = TrainerDAO.deleteTrainer(id);
			if (result == true) {
				RunningEndView.showSuccessView("���Բ��� �Է��Ͻ� ID�� ���� ��ȣ�ڰ� �����Ǿ����ϴ�");
			} else {
				RunningEndView.showSuccessView("���Բ��� �Է��Ͻ� ID�� ���� ��ȣ�ڴ� �������� �ʽ��ϴ�");
			}
		} catch (SQLException s) {
			s.printStackTrace();
			RunningEndView.showError("�Է��Ͻ� ID �˻��� ���� �߻�");
		}
	}

	// ID�� Pokemon ���� �˻�
	public static void getPokemon(int id) {
		PokemonDTO pokemon = null;
		try {
			pokemon = PokemonDAO.getPokemon(id);
			if (pokemon != null) {
				RunningEndView.pokemonView(pokemon);
				RunningEndView.imageView(pokemon);
			} else {
				RunningEndView.showSuccessView("���Բ��� �Է��Ͻ� ID�� ���� ���ϸ��� �������� �ʽ��ϴ�");
			}
		} catch (SQLException s) {
			s.printStackTrace();
			RunningEndView.showError("�Է��Ͻ� ID �˻��� ���� �߻�");
		}
	}

	// Pokemon id�� �Կ���� ��ȸ
	public static void getHospital(int pid) {
		HospitalDTO hospital = null;
		try {
			hospital = HospitalDAO.getHospital(pid);
			if (hospital != null) {
				RunningEndView.hospitalView(hospital);
			} else {
				RunningEndView.showSuccessView("���Բ��� �Է��Ͻ� ���ϸ� �̸��� ���� ȯ�ڴ� �������� �ʽ��ϴ�");
			}
		} catch (SQLException s) {
			s.printStackTrace();
			RunningEndView.showError("�Է��Ͻ� �̸��� ���ϸ� ȯ�� �˻��� ���� �߻�");
		}
	}

	// ��� ȯ�� �Կ� ��Ȳ ����
	public static void getAllHospital() {
		ArrayList<HospitalDTO> allHospital = null;
		try {
			allHospital = HospitalDAO.getAllHospital();
			if (allHospital.size() != 0) {
				RunningEndView.allHospitalDataPrint(allHospital);
			} else {
				RunningEndView.showSuccessView("���Բ��� ��û�Ͻ� �����ʹ� �������� �ʽ��ϴ�");
			}
		} catch (SQLException s) {
			s.printStackTrace();
			RunningEndView.showError("�Կ���Ȳ �˻��� ���� �߻�");
		}
	}

	// ���ο� Hospital ���
	public static void addHospitalReqRes(int no, int did, int tid, int pid, String indate, String outdate) {
		try {
			boolean result = HospitalDAO.addHospital(new HospitalDTO(no, did, tid, pid, indate, outdate));
			if (result = true) {
				RunningEndView.showSuccessView("�Է��Ͻ� ������ �Կ� ��ο� ���������� �ԷµǾ����ϴ�");
			} else {
				RunningEndView.showSuccessView("�Է��Ͻ� ������ �Կ� ��ο� �Է��ϴµ� �����߽��ϴ�");
			}
		} catch (SQLException s) {
			s.printStackTrace();
			RunningEndView.showError("�Կ� ��� ����� ���� �߻�");
		}
	}

	// �Կ���Ȳ ����
	public static void refreshHospital() {
		try {
			boolean result = HospitalDAO.refreshHospital();
			if (result != true) {
				RunningEndView.showSuccessView("�Կ� ��Ȳ ������ �Ϸ��Ͽ����ϴ�.");
			} else {
				RunningEndView.showSuccessView("�Կ� ��Ȳ ���� �� ������ �߻��߽��ϴ�.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			RunningEndView.showError("�Կ� ��Ȳ ���� ���� �߻�");
		}
	}
}
