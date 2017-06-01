//package pl.biltec;
//
//import org.assertj.core.api.Assertions;
//import org.junit.Test;
//import pl.biltec.keymouse.domain.Area;
//
//public class AreaTest {
//
//	@Test
//	public void shouldEqualsWorks() throws Exception {
//		//when
//		Area area = new Area(0, 0, 1000, 100, 10, splitVertical);
//
//		//then
//		Assertions.assertThat(area).isEqualTo(new Area(0, 0, 1000, 100, 10, splitVertical));
//	}
//
//	@Test
//	public void shouldMovingLeftTopWorksAsExpected() throws Exception {
//		//given
//		Area area = new Area(0, 0, 1000, 100, 10, splitVertical);
//
//		//when
//		Area result1 = area.move(0);
//		Area result2 = result1.move(0);
//		Area result3 = result2.move(0);
//		Area result4 = result3.move(0);
//		Area result5 = result4.move(0);
//		Area result6 = result5.move(0);
//		Area result7 = result6.move(0);
//		Area result8 = result7.move(0);
//
//		//then
//		Assertions.assertThat(result1).isEqualTo(new Area(0, 0, 100, 100, 10, splitVertical));
//		System.out.println(result1);
//		Assertions.assertThat(result2).isEqualTo(new Area(0, 0, 100, 10, 10, splitVertical));
//		System.out.println(result2);
//		Assertions.assertThat(result3).isEqualTo(new Area(0, 0, 10, 10, 10, splitVertical));
//		System.out.println(result3);
//		Assertions.assertThat(result4).isEqualTo(new Area(0, 0, 10, 1, 10, splitVertical));
//		System.out.println(result4);
//		Assertions.assertThat(result5).isEqualTo(new Area(0, 0, 1, 1, 10, splitVertical));
//		System.out.println(result5);
//		Assertions.assertThat(result6).isEqualTo(new Area(0, 0, 1, 0, 10, splitVertical));
//		System.out.println(result6);
//		Assertions.assertThat(result7).isEqualTo(new Area(0, 0, 0, 0, 10, splitVertical));
//		System.out.println(result7);
//		Assertions.assertThat(result8).isEqualTo(new Area(0, 0, 0, 0, 10, splitVertical));
//		System.out.println(result8);
//	}
//
//
//	@Test
//	public void shouldMovingRightBottomWorksAsExpected() throws Exception {
//		//given
//		Area area = new Area(0, 0, 1000, 100, 10, splitVertical);
//
//		//when
//		Area result1 = area.move(9);
//		Area result2 = result1.move(9);
//		Area result3 = result2.move(9);
//		Area result4 = result3.move(9);
//		Area result5 = result4.move(9);
//		Area result6 = result5.move(9);
//		Area result7 = result6.move(9);
//		Area result8 = result7.move(9);
//
//		//then
//		Assertions.assertThat(result1).isEqualTo(new Area(900, 0, 100, 100, 10, splitVertical));
//		System.out.println(result1);
//		Assertions.assertThat(result2).isEqualTo(new Area(900, 90, 100, 10, 10, splitVertical));
//		System.out.println(result2);
//		Assertions.assertThat(result3).isEqualTo(new Area(990, 90, 10, 10, 10, splitVertical));
//		System.out.println(result3);
//		Assertions.assertThat(result4).isEqualTo(new Area(990, 99, 10, 1, 10, splitVertical));
//		System.out.println(result4);
//		Assertions.assertThat(result5).isEqualTo(new Area(999, 99, 1, 1, 10, splitVertical));
//		System.out.println(result5);
//		Assertions.assertThat(result6).isEqualTo(new Area(999, 99, 1, 0, 10, splitVertical));
//		System.out.println(result6);
//		Assertions.assertThat(result7).isEqualTo(new Area(999, 99, 0, 0, 10, splitVertical));
//		System.out.println(result7);
//		Assertions.assertThat(result8).isEqualTo(new Area(999, 99, 0, 0, 10, splitVertical));
//		System.out.println(result8);
//	}
//}