# dat 읽기

```java
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ex {
	public static void main(String[] args) {

		String path = "D:\\Dev\\JAVA\\data\\";
		
		File dir = new File(path);
		File[] fileList = dir.listFiles();

		List<ArrayList<HashMap<String, String>>> allGradeList = new ArrayList<ArrayList<HashMap<String, String>>>();

		for (File file : fileList) {

			List<HashMap<String, String>> gradeList = new ArrayList<HashMap<String, String>>();

			if (file.isFile()) {

				String fileName = file.getName();
				String realFileName = Arrays.asList(fileName.split("\\.")).get(0);
				
				try {
					String filePath = path + fileName;

					BufferedReader br = new BufferedReader(
							new InputStreamReader(new BufferedInputStream(new FileInputStream(filePath))));

					String line = "";
					while ((line = br.readLine()) != null) {

						Map<String, String> userGrade = new HashMap<String, String>();

						List<String> list = Arrays.asList(line.split("\t"));

						userGrade.put("name", list.get(0));
						userGrade.put(realFileName, list.get(1));

						gradeList.add((HashMap<String, String>) userGrade);
					}
					
					allGradeList.add((ArrayList<HashMap<String, String>>) gradeList);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		List<Map<String, String>> mapList = new ArrayList<Map<String,String>>();
		
		for (ArrayList<HashMap<String, String>> mapLs : allGradeList) {
			System.out.println(mapLs);	// [{name=정형돈, math=64}, {name=정준하, math=39},...]
			
			Iterator it = mapLs.iterator();
			while (it.hasNext()) {

				Map<String, String> map = new HashMap<String, String>();
				
				map = (Map<String, String>) it.next();
				
				System.out.println(map);	// {name=정형돈, math=64}
				
				Iterator mapIt = map.keySet().iterator();
				
				while (mapIt.hasNext()) {
					String key = (String) mapIt.next();
					System.out.println(map.get(key));	// 정형돈 \t 64
				}
				
			}
		}
	}
}

```

