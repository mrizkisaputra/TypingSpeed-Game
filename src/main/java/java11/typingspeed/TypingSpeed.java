package java11.typingspeed;

import java.time.LocalTime;
import java.util.Random;
import java.util.Scanner;

public class TypingSpeed {
  private static final Scanner scan = new Scanner(System.in);
  private static final StringBuilder randomWords = new StringBuilder();
  public static final String[][] modelDataTypingWords = {
    {"Jika", "Anda melihat", "seorang", "penyendiri", "bagaimanapun penjelasan", "mereka..."},
    {"Aku", "sangat mengharapkan", "dia", "untuk", "menjadi kekasihku.", "Apakah dia mau..."},
    {"You Know,","they say","when","you talk to","God it's","prayer for you so pray..."},
    {"I admit that twice","two make","fours is","an excellent","thing,","but if we but"},
    {"Biarlah aku","pergi jangan","lagi","kau tangisi","semoga","pilihan mu yang bagus"},
    {"Not sure","if you know","this","But when we","frist me","I got so nervous I cool"},
  };


/*==================================================[START: Flow Business Logic]==================================================*/
  /**
   * @desc untuk menghitung waktu mundur start game
   * @throws InterruptedException
   */
  public static void countDown() throws InterruptedException {
    System.out.println("\t\t\t [_ START GAME _]\n");

    Thread.sleep(1000);
    for (var countNumber = 3; countNumber >= 1; countNumber--) {
      if (countNumber == 3) System.out.print("\t\t\t");
      System.out.print(countNumber+"\t");
      Thread.sleep(1000);

      if (countNumber == 1) System.out.println("\n\t\t\t      GO!!!\n");
    }
  }


  /**
   * @desc untuk memilih modelDataTypingWords secara random
   * @return int
   */
  public static int randomChooseTypingWords() {
    Random random = new Random();
    int rand = random.nextInt(6);

    return rand;
  }


  /**
   * @desc untuk menampilkan modelDataTypingWords yang dipilih secara random
   * @return StringBuilder
   */
  public static StringBuilder showModelDataTypingWords() {
    var randomNumber = randomChooseTypingWords();

    for (var rows = randomNumber; rows <= randomNumber; rows++) {
      for (var column = 0; column < 6; column++) {
        randomWords.append(modelDataTypingWords[rows][column]+" ");
      }
    }

    return randomWords;
  }


  /**
   * @desc untuk player typing words
   * @return String
   */
  public static String playerTypingWords() {
    return scan.nextLine();
  }


  /**
   * @desc untuk menghitung score wpm player
   * @param startTime
   * @param endTime
   * @return int
   */
  public static int countWpm(double startTime, double endTime) {
    double elapseTime = endTime - startTime;
    double seconds = elapseTime / 1_000_000_000.0;
    /* Formula WPM ((length Character / 5) / minute) * 60 = wpm!  */
    int wpm = (int) ( (((double)randomWords.length() / 5) / seconds) * 60 );

    return wpm;
  }
/*==================================================[END: Flow Business Logic]==================================================*/

/*==================================================[START: Flow View]==================================================*/
  /**
   * @desc ini merupakan view utama
   */
  public static void viewMain() {
    try {
      /*Jalankan Count Down*/
      countDown();

      /*tampilkan random words*/
      var randomWords = showModelDataTypingWords();
      System.out.println("+Typing Words+------------------------------------------------------------+\n"+"|\t\t\t\t\t\t\t\t\t  |");
      System.out.println("| "+randomWords.toString()+" |");
      System.out.println("+-------------------------------------------------------------------------+");

      double startTime = LocalTime.now().toNanoOfDay();

      /*Player Typing*/
      viewPlayerTyping();

      double endTime = LocalTime.now().toNanoOfDay();
      /*hitung score wpm*/
      viewScoreWpm(startTime, endTime);

    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }


  /**
   * @desc ini adalah view untuk player
   */
  public static void viewPlayerTyping() {
    System.out.println("\n+Player Typing+------------------------------------------------------------+\n");
    System.out.print(" "); playerTypingWords();
    System.out.println("+--------------------------------------------------------------------------+");
  }


  /**
   * @desc ini adalah view untuk hasil score
   */
  public static void viewScoreWpm(double startTime, double endTime) {
    System.out.println("\t\t\t+----------+------------+");
    System.out.println("\t\t\t| Score    | "+countWpm(startTime, endTime)+" Wpm!\t|");
    System.out.println("\t\t\t+----------+------------+");
  }
/*==================================================[END: Flow View]====================================================*/


  /*Main Program*/
  public static void main(String[] xxx) {
    viewMain();
  }
}
