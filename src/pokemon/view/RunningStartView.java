package pokemon.view;

import java.util.Scanner;
import pokemon.service.HospitalRecordController;

public class RunningStartView {
	public static void main(String[] args) {
		HospitalRecordController controller = HospitalRecordController.getInstance();
		Scanner sc = new Scanner(System.in);
		int i = 0;
		// 회원가입
		System.out.println("******************************************************" + "\n");
		System.out.println("***-------------♥어서오세요! 사랑으로 치료하는 포켓몬병원입니다 ♥----------- ***" + "\n");
		System.out.println("******************************************************");

		while (true) {
			System.out.println("-------------(1)보호자 (2)환자 (3)담당의 (4)병원--------------------");

			int a = sc.nextInt();

			switch (a) {
			case 1:
				i = 1;
				break;
			case 2:
				i = 2;
				break;
			case 3:
				i = 3;
				break;
			case 4:
				i = 4;
				break;
			default:
				System.out.println("-------------잘못된 번호를 입력했습니다 다시 입력해주세요--------------------");
				break;
			}
			while (true) {
				if (i == 1) {
					System.out.println("-------------(1)보호자 등록 (2)보호자 탈퇴 (3)이전 화면---------------");
					int trainer = sc.nextInt();
					int i1 = 0;
					switch (trainer) {
					case 1:
						i1 = 1;
						break;
					case 2:
						i1 = 2;
						break;
					case 3:
						i1 = 3;
						break;
					default:
						System.out.println("-------------잘못된 번호를 입력했습니다 다시 입력해주세요--------------------");
						break;
					}
					if (i1 == 1) {
						System.out.println("-------------본인의 정보를 입력해주세요-------------------------------");
						String name, gender, region, pokemon1, pokemon2, pokemon3, pokemon4, checkid;
						int id, age;
						System.out.println("[트레이너 번호 입력]");
						id = sc.nextInt();
						System.out.println("[이름 입력]");
						name = sc.next();
						System.out.println("[나이 입력]");
						age = sc.nextInt();
						System.out.println("[성별 입력]");
						gender = sc.next();
						System.out.println("[출신지 입력]");
						region = sc.next();
						System.out.println("[보유하고 계신 포켓몬(1)]");
						pokemon1 = sc.next();
						System.out.println("[보유하고 계신 포켓몬(2]");
						pokemon2 = sc.next();
						System.out.println("[보유하고 계신 포켓몬(3)]");
						pokemon3 = sc.next();
						System.out.println("[보유하고 계신 포켓몬(4)]");
						pokemon4 = sc.next();

						controller.addTrainerReqRes(id, name, age, gender, region, pokemon1, pokemon2, pokemon3, pokemon4);
						System.out.println("---------------본인의 정보가 제대로 입력되었는지 확인해주세요!----------------");
						System.out.println("[트레이터 번호 입력]");
						checkid = sc.next();
						controller.getTrainer(checkid);
					} else if (i1 == 2) {
						System.out.println("-------------저희 병원에서 귀하의 정보를 삭제합니다---------------------------");
						System.out.println("[트레이너 번호 입력]");
						int trainerid;
						trainerid = sc.nextInt();
						controller.deleteTrainer(trainerid);
						System.out.println("-------------------------------------------------------------------------");
					} else if (i1 == 3) {
						break;
					}
				} else if (i == 2) {
					System.out.println("-------------(1)포켓몬 검색 (2)입원기록 검색 (3)이전 화면--------------");
					int pokemon = sc.nextInt();
					int i2 = 0;
					switch (pokemon) {
					case 1:
						i2 = 1;
						break;
					case 2:
						i2 = 2;
						break;
					case 3:
						i2 = 3;
						break;
					default:
						System.out.println("-------------잘못된 번호를 입력했습니다 다시 입력해주세요--------------------");
						break;
					}
					if (i2 == 1) {
						System.out.println("-------------환자의 ID를 입력해주세요-------------------------------");
						int no;
						System.out.println("[환자 ID 입력]");
						no = sc.nextInt();
						controller.getPokemon(no);
						System.out.println("-------------------------------------------------------------------");
					} else if (i2 == 2) {
						System.out.println("-------------환자의 기록을 조회합니다.---------------------------");
						System.out.println("[환자 ID 입력]");
						int id;
						id = sc.nextInt();
						controller.getHospital(id);
						System.out.println("-------------------------------------------------------------------------");
					} else if (i2 == 3) {
						break;
					}
				} else if (i == 3) {
					System.out.println("---------------(1)의사 검색 (2) 전공 변경 (3)이전 화면--------------------");
					int doctor = sc.nextInt();
					int i3 = 0;
					switch (doctor) {
					case 1:
						i3 = 1;
						break;
					case 2:
						i3 = 2;
						break;
					case 3:
						i3 = 3;
						break;
					default:
						System.out.println("-------------잘못된 번호를 입력했습니다 다시 입력해주세요--------------------");
						break;
					}
					if (i3 == 1) {
						System.out.println("-------------의사 ID를 입력해주세요-------------------------------");
						int doctorid;
						System.out.println("[의사 ID 입력]");
						doctorid = sc.nextInt();
						controller.getDoctor(doctorid);
						System.out.println("-------------------------------------------------------------------");
					} else if (i3 == 2) {
						System.out.println("-------------의사의 전공을 변경합니다.---------------------------");
						int id;
						String major;
						System.out.println("[의사 ID 입력]");
						id = sc.nextInt();
						System.out.println("[변경할 전공 입력]");
						major = sc.next();
						controller.updateDoctor(id, major);
						System.out.println("-------------------------------------------------------------------------");
					} else if (i3 == 3) {
						break;
					}
				} else if (i == 4) {
					System.out.println(
							"-------------(1) 모든 의사 검색 (2) 모든 보호자 검색 (3) 모든 입원현황 검색 (4) 장부 입력 (5)퇴원 수속 (6) 이전 화면-----------------");
					int data = sc.nextInt();
					int i4 = 0;
					switch (data) {
					case 1:
						i4 = 1;
						break;
					case 2:
						i4 = 2;
						break;
					case 3:
						i4 = 3;
						break;
					case 4:
						i4 = 4;
						break;
					case 5:
						i4 = 5;
						break;
					case 6:
						i4 = 6;
						break;
					default:
						System.out.println("-------------잘못된 번호를 입력했습니다 다시 입력해주세요--------------------");
						break;
					}
					if (i4 == 1) {
						System.out.println("-------------저희 병원의 모든 의사들을 소개합니다~-------------------------------");
						controller.getAllDoctors();
						System.out.println(
								"-------------------------------------------------------------------------------");
					} else if (i4 == 2) {
						System.out.println("-------------저희 병원에 기록이 존재하는 보호자들입니다---------------------------");
						controller.getAllTrainers();
						System.out.println(
								"-------------------------------------------------------------------------------");
					} else if (i4 == 3) {
						System.out.println("-------------저희 병원의 입원 현황입니다-------------------------------------");
						controller.getAllHospital();
						System.out
								.println("---------------------------------------------------------------------------");
					} else if (i4 == 4) {
						System.out.println("-----------------------장부 입력 창입니다-----------------------------------");
						int no, did, tid, pid;
						String indate, outdate;
						System.out.println("[장부 번호 입력]");
						no = sc.nextInt();
						System.out.println("[의사 ID 입력]");
						did = sc.nextInt();
						System.out.println("[보호자 ID 입력]");
						tid = sc.nextInt();
						System.out.println("[환자 ID 입력]");
						pid = sc.nextInt();
						System.out.println("[입원일 입력]");
						indate = sc.next();
						System.out.println("[퇴원 예정일 입력]");
						outdate = sc.next();

						controller.addHospitalReqRes(no, did, tid, pid, indate, outdate);
						System.out.println("-------------------------------------------------------------------------");
					} else if (i4 == 5) {
						System.out.println("-------------저희 병원에서 퇴원 수속 이후 갱신된 입원 현황입니다--------------");
						controller.refreshHospital();
						System.out.println("-------------------------------------------------------------------------");
					} else if (i4 == 6) {
						break;
					}
				}
			}
		}
	}
}
