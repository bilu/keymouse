package pl.biltec.sandbox;

import java.awt.*;

public class MonitorDetect {


	public static void main(String[] args) {
		GraphicsEnvironment g = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice[] devices = g.getScreenDevices();

		for (int i = 0; i < devices.length; i++) {
			System.out.println("Width:" + devices[i].getDisplayMode().getWidth());
			System.out.println("Height:" + devices[i].getDisplayMode().getHeight());
			System.out.println("IDstring:"+ devices[i].getIDstring());
			System.out.println("Type:"+ devices[i].getType());
			System.out.printf("---");
		}


		/*

/home/pbilewic/programs/jdk1.8.0_112/bin/java -Didea.launcher.port=7534 -Didea.launcher.bin.path=/home/pbilewic/programs/idea/bin -Dfile.encoding=UTF-8 -classpath /home/pbilewic/programs/jdk1.8.0_112/jre/lib/charsets.jar:/home/pbilewic/programs/jdk1.8.0_112/jre/lib/deploy.jar:/home/pbilewic/programs/jdk1.8.0_112/jre/lib/ext/cldrdata.jar:/home/pbilewic/programs/jdk1.8.0_112/jre/lib/ext/dnsns.jar:/home/pbilewic/programs/jdk1.8.0_112/jre/lib/ext/jaccess.jar:/home/pbilewic/programs/jdk1.8.0_112/jre/lib/ext/jfxrt.jar:/home/pbilewic/programs/jdk1.8.0_112/jre/lib/ext/localedata.jar:/home/pbilewic/programs/jdk1.8.0_112/jre/lib/ext/nashorn.jar:/home/pbilewic/programs/jdk1.8.0_112/jre/lib/ext/sunec.jar:/home/pbilewic/programs/jdk1.8.0_112/jre/lib/ext/sunjce_provider.jar:/home/pbilewic/programs/jdk1.8.0_112/jre/lib/ext/sunpkcs11.jar:/home/pbilewic/programs/jdk1.8.0_112/jre/lib/ext/zipfs.jar:/home/pbilewic/programs/jdk1.8.0_112/jre/lib/javaws.jar:/home/pbilewic/programs/jdk1.8.0_112/jre/lib/jce.jar:/home/pbilewic/programs/jdk1.8.0_112/jre/lib/jfr.jar:/home/pbilewic/programs/jdk1.8.0_112/jre/lib/jfxswt.jar:/home/pbilewic/programs/jdk1.8.0_112/jre/lib/jsse.jar:/home/pbilewic/programs/jdk1.8.0_112/jre/lib/management-agent.jar:/home/pbilewic/programs/jdk1.8.0_112/jre/lib/plugin.jar:/home/pbilewic/programs/jdk1.8.0_112/jre/lib/resources.jar:/home/pbilewic/programs/jdk1.8.0_112/jre/lib/rt.jar:/home/pbilewic/sources/keymouse/target/classes:/home/pbilewic/.m2/repository/org/assertj/assertj-core/3.5.2/assertj-core-3.5.2.jar:/home/pbilewic/.m2/repository/junit/junit/4.12/junit-4.12.jar:/home/pbilewic/.m2/repository/org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar:/home/pbilewic/programs/idea/lib/idea_rt.jar com.intellij.rt.execution.application.AppMain pl.biltec.sandbox.MonitorDetect
Width:3600
Height:1667
IDstring::0.0
Type:0
---Width:1680
Height:1050
IDstring::0.1
Type:0


***
Width:3600
Height:1080
IDstring::0.0
Type:0
---Width:1680
Height:1050
IDstring::0.1
Type:0

---

		 */

	}
}
