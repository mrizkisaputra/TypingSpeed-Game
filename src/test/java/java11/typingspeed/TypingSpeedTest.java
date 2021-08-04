package java11.typingspeed;

import java.time.LocalTime;

import org.junit.jupiter.api.*;


public class TypingSpeedTest {

  @Test
  @Disabled
  public void testCountDown() throws InterruptedException {
    TypingSpeed.countDown();
  }


  @Test
  @Disabled
  public void testRandomChooseTypingWords() {
    for (var i = 1; i <= 10; i++) {
      System.out.print(TypingSpeed.randomChooseTypingWords()+" ");
    }
  }


  @Test
  @Disabled
  public void testShowModelDataTypingWords() {
    var words = TypingSpeed.showModelDataTypingWords();
    System.out.println("+ Typing Words +----------------------------------------------------------+\n"+"|\t\t\t\t\t\t\t\t\t  |");
    System.out.println("| "+words.toString()+" |");
    System.out.println("+-------------------------------------------------------------------------+");
  }


  @Test
  @Disabled
  public void testPlayerTypingWords() {
    var inputWords = TypingSpeed.playerTypingWords();
    System.out.print(inputWords);
  }


  @Test
  @Disabled
  public void testCountWpm() {
    double startTime = LocalTime.now().toNanoOfDay();

    testPlayerTypingWords();

    double endTime = LocalTime.now().toNanoOfDay();
    var result = TypingSpeed.countWpm(startTime, endTime);

    System.out.println(result);
  }
}
