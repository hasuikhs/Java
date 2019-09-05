## Java 입출력(BufferedReader, StringTokenizer)

- #### BufferedReader

  - Scanner로 한줄로 입력시 , sc.nextInt()를 호출하는 것은 비효율적이며,

    입력갯수가 큰 알고리즘 문제의 경우 시간제한에 걸림

    ```java
    1 2 3 4 5 6 7 8 9 10 11 12	// 한줄 입력
        
    for (int i = 0; i < 12; i++){
        sc.nextInt();
    }
    ```

  - 그래서 BufferedReader를 이용하여 문자열로 받고 split 메서드를 이용해서 공백을 기준으로 잘라서 사용

  - Integer.parseint() 형변환을 통해 사용

    ```java
    1 2 3 4 5 6 7 8 9 10 11 12	// 한줄 입력
        
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    String[] s = br.readLine().split(" ");
    
    // s[0] = "1"; Integer.parseInt(s[0]) => 1
    // ...
    ```

- #### StringTokenizer

  - StringTokenizer는 공백이 있다면 뒤에 문자열이 공백 자리를 땡겨 채움

  - StringTokenizer가 BufferedReader 보다 빠르게 사용 가능

  - 문자열을 자르기 위해 split을 사용할 때보다 StringTokenizerd의 nextToken() 메서드는 단순히 공백 자리를 땡겨 채움, 그렇기에 속도 차이가 존재

  - 인덱스 접근과 같은 처리가 필요없다면 StringTokenizer를 사용하는 것이 효율적

    ```java
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    // AB CDD EFFF GH 입력
    st.nextToken();		// AB
    st.nextToken();		// CDD
    ```

  - 공백말고도 다른 구분자를 사용 가능함

    ```java
    String str = "this%is%java";
    StringTokenizer st = new StringTokenizer(str, "%%");
    
    while(st.hasMoreTokens()){
        System.out.println(st.nextToken());
    }
    ```