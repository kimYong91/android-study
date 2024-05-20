# 안드로이드

## 플랫폼 아키텍처
  - [플레폼 아키텍처](https://developer.android.com/guide/platform?hl=ko)
  - 구성
    - 리눅스 커널
    - 하드웨어 추상화 계층(HAL)
    - 안드로이드 런타임(ART)
    - *Java API Framework*
    - 시스템 앱

## 코드명, 버전, API 레벨
  - [코드명, 버전, API 레벨](https://source.android.com/docs/setup/about/build-numbers?hl=ko)

## 안드로이드 프로젝트 디렉터리 구조

```
MyAndroidApp/
 ├── .idea/                      # 프로젝트 설정 파일
 ├── app/                        # 메인 애플리케이션 모듈
 │    ├── build/                 # 빌드된 파일들
 │    ├── src/                   # 소스 코드 디렉터리
 │    │   ├── main/              # 메인 소스 파일
 │    │   │   ├── java/          # Java/Kotlin 소스 코드
 │    │   │   │   └── com/
 │    │   │   │       └── example/
 │    │   │   │           └── myandroidapp/
 │    │   │   │               └── MainActivity.java  # 메인 액티비티
 │    │   │   ├── res/           # 리소스 파일들
 │    │   │   │   ├── drawable/  # 이미지 파일
 │    │   │   │   ├── layout/    # 레이아웃 XML 파일
 │    │   │   │   ├── mipmap/    # 앱 아이콘
 │    │   │   │   ├── values/    # 문자열, 색상, 스타일 등
 │    │   │   └── AndroidManifest.xml  # 애플리케이션 매니페스트 파일
 │    │   ├── androidTest/       # 통합 테스트 소스
 │    │   └── test/              # 유닛 테스트 소스
 │    └── build.gradle           # 모듈별 빌드 파일
 ├── build/                      # 최상위 빌드된 파일들
 ├── gradle/                     # 그레이들 설정 디렉터리
 ├── .gitignore                  # 깃 무시 파일
 ├── build.gradle                # 최상위 빌드 파일
 └── settings.gradle             # 프로젝트 포함 모듈 설정
```

## 안드로이드 앱 컴포넌트
1. Activity : 앱의 화면을 담당하는 기본 구성요소
2. Intent : 액티비티 간의 전환 또는 외부 앱과의 데이터 교환을 위한 메시지
3. Service : 백그라운드에서 동작하는 작업 단위
4. Broadcast Receiver : 시스템 또는 다른 앱에서 발생하는 이벤트 수신
5. Content Provider : 앱 간 데이터 공유를 위한 인터페이스

## 안드로이드 개발환경
- 안드로이드 스튜디오
- 안드로이드 SDK : 안드로이드 앱을 개발하기 위한 도구 및 라이브러리 모음
- 에뮬레이터(Emulator. AVD) : 안드로이드 앱을 테스트할 수 있는 가상 디바이스

## XML(eXtensible Markup Language)
  - 데이터를 구조화하고 나타내는 마크럽 언어
  - 사람이 이해할 수 있는 구조
  - 기계가 해석할 수 있는 데이터 형식
  - 반정형 데이터

### XML 구성요소
  1. 선언부
  2. 태그 (Tag)
     - 데이터를 감싸는 구조화 된 요소
     - 시작 태그와 종료 태그의 쌍으로 이루어 짐 (열면 닫아야 함)
```xml
<data>데이터 내용</data>
```
  3. 엘리먼트(Element)
     - 시작 태그와 종료 태그 사이에 있는 컨텐츠
     - 태그 내부의 하위 태그. 하위 엘리멘트(요소)를 포함
     - 태그 + 컨텐츠(내용)
```xml
<person>
    <name>홍길동</name>
    <age>30</age>
</person>
```  
  4. 속성(Attributes)
     - 태그에 추가 정보를 제공
     - Key-Value 쌍
```xml
<person name="홍길동" age="30" />
```
  5. 네임스페이스(Namespace)
     - 태그 이름의 충돌을 피하기 위해 고유한 접두사를 주여
     - 선언부 또는 태그 내부의 'xmlns' 속성을 사용하여 URI로 정의
```xml
<myname:person xmlns:myname="http://myname.com/myname">
    <myname:name>홍길동</myname:name>
</myname:person>
```

  - 주의 사항
    - XML 태그는 대소문자를 구분한다.
    - 태그의 쌍은 정확하게 매칭이 되어야 함
    - 속성의 값은 반드시 큰따옴표나 작은따옴표로 감싸야 함
    - 루트 엘리먼트(최상위)는 하나여야 함.

## 뷰의 레이아웃
- [뷰의 레이아웃](https://developer.android.com/develop/ui/views/layout/declaring-layout?hl=ko)
- View 클래스 : (화면 구성과 관련된 클래스)
  - ViewGroup : View의 하위 클래스지만, 화면에는 아무것도 출력하지 않고
                다른 뷰 여러개를 묶는 그릇 역할 클래스
    - XXXLayout : 뷰의 컨테이너 역할
  - TextView, XXXView : 특정 UI를 출력할 목적으로 사용하는 클래스

## 뷰 바인딩
- 레이아웃 XML 파일에 선언한 뷰 객체를 코드에서 쉽게 이용하는 방법
- 모듈 단위 build.gradle 파일 android 영역에 설정 선언 추가
  ```
  android {
   ...(생략)
   viewBinding { enable = true }
   ...
  }
  ```
- 그레이들을 동기화 하면, 자동으로 뷰 객체 포함하는 클래스가 생성
- 레이아웃 XML 파일의 이름을 따름
    - 클래스이름 : 첫글자 및 _ 뒤를 대문자로 바꾼 후 'Binding' 추가
        - activity_main.xml -> ActivityMainBinding
   ```kt
        // 바인딩 객체 획득 (View Binding)
        val binding = ActivityBindingBinding.inflate(layoutInflater)

        // 바인딩 객체로 화면을 출력
        setContentView(binding.root)

        // findViewById를 사용하지 않고 뷰 객체 사용
        binding.visibleButton.setOnClickListener {
            binding.targetView.visibility = View.VISIBLE
        }
   ```

## 뷰를 배치하는 레이아웃
1. 수평, 수직으로 배치 - LinearLayout
2. 상대적은 위치로 배치 - RelativeLayout
3. 겹쳐서 배치 - FrameLayout
4. 격자 형태로 배치 - GridLayout
5. 제약조건으로 배치 - ConstraintLayout

## 사용자 이벤트 처리
1. 터치 이벤트
2. 키 이벤트
3. 뷰 이벤트
- [이벤트 공식문서](https://developer.android.com/develop/ui/views/touch-and-input/input-events?hl=ko)

## 리소스

- [공식문서 : 앱 리소스 개요](https://developer.android.com/guide/topics/resources/providing-resources?hl=ko)
- [XML도형 드로어블](https://developer.android.com/guide/topics/resources/drawable-resource?hl=ko#Shape)

### 리소스의 종류

#### 1. 레이아웃 리소스 (Layout Resources)
- 파일 위치: `res/layout`
- 확장자: `.xml`
- 설명: 액티비티, 프래그먼트, 또는 앱의 UI 부분의 뷰 구조를 정의합니다. 레이아웃 에디터를 통해 드래그 앤 드롭으로 구성할 수 있으며, XML로 직접 작성도 가능합니다.

#### 2. 이미지 리소스 (Drawable Resources)
- 파일 위치: `res/drawable`
- 확장자: `.png`, `.jpg`, `.gif`, `.xml` 등
- 설명: 앱에서 사용하는 이미지 파일들을 저장합니다. 해상도에 따라 다른 폴더(`drawable-hdpi`, `drawable-mdpi` 등)에 저장하여 다양한 화면 밀도를 지원합니다.

#### 3. 문자열 리소스 (String Resources)
- 파일 위치: `res/values`
- 설명: 모든 텍스트 콘텐츠를 저장합니다. 이를 통해 다국어 지원을 쉽게 구현할 수 있으며, `strings.xml` 파일에서 관리합니다.

#### 4. 색상 리소스 (Color Resources)
- 파일 위치: `res/values`
- 설명: 색상 코드를 정의합니다. `colors.xml` 파일을 통해 앱 전체의 색상 테마를 일관되게 관리할 수 있습니다.

#### 5. 치수 리소스 (Dimension Resources)
- 파일 위치: `res/values`
- 설명: 모든 치수 정보(예: 마진, 패딩, 폰트 크기)를 저장합니다. `dimens.xml` 파일에서 관리하여 여러 뷰에서 재사용 가능합니다.

#### 6. 스타일 리소스 (Style Resources)
- 파일 위치: `res/values`
- 설명: 앱의 테마나 스타일을 정의합니다. `styles.xml` 파일을 통해 디자인을 일관되게 유지할 수 있습니다.

#### 사용하기
1. 문자열 리소스: `R.string.resource_name`을 사용하여 문자열 리소스를 참조합니다.
    - 예를 들어 한국어와 영어를 만들어야 한다면 한국어용 string과 영어용 string의 파일이름과 
2. 색상 리소스: `ContextCompat.getColor(context, R.color.resource_name)`을 사용하여 색상 리소스를 참조합니다.
3. 크기 리소스: `getResources().getDimension(R.dimen.resource_name)`을 사용하여 크기 리소스를 참조합니다.
4. 스타일 리소스: XML 레이아웃 파일에서 `style` 속성을 사용하여 스타일을 적용합니다.
5. 다국어 지원: 각 언어에 맞는 `strings.xml` 파일을 `res/values` 하위 폴더에 추가하여 다국어를 지원합니다.



### 프로젝트에 클립아트(아이콘) 추가하기

1. 안드로이드 스튜디오에서 프로젝트 열기
    - 안드로이드 스튜디오를 열고 작업 중인 프로젝트를 엽니다.
2. 리소스 디렉토리 열기
    - `res` 디렉토리를 열고 `drawable` 폴더를 확인합니다. 클립아트(아이콘)는 보통 이 폴더에 추가됩니다.
3. 새 아이콘 추가하기
    - `drawable` 폴더를 마우스 오른쪽 버튼으로 클릭하고, `New` > `Vector Asset`을 선택합니다.
4. 벡터 자산(Vector Asset) 설정
    - `Vector Asset Studio` 창이 열립니다.
    - `Icon` 탭에서 `Clip Art` 버튼을 클릭합니다.
5. 클립아트 선택
    - `Select Icon` 창이 열리면, 원하는 클립아트를 선택합니다. 여기에는 다양한 기본 제공 아이콘이 있습니다.
    - 원하는 아이콘을 선택하고 `OK` 버튼을 클릭합니다.
6. 아이콘 설정 및 추가
    - `Vector Asset Studio` 창에서 아이콘 이름, 크기, 색상 등을 설정할 수 있습니다.
    - 설정이 완료되면 `Next` 버튼을 클릭하고, 마지막으로 `Finish` 버튼을 클릭합니다.
7. 선택한 클립아트가 `drawable` 폴더에 `XML` 파일로 추가됩니다.

### XML 레이아웃 파일에 클립아트(아이콘) 사용하기


#### 예시: ImageView에 클립아트 추가
```xml
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <ImageView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:src="@drawable/ic_your_icon_name"  <!-- 여기에 추가한 아이콘 이름을 사용 -->
        android:layout_centerInParent="true"/>
</RelativeLayout>
```

### 무료 아이콘 사이트 추천

1. [Google Icon / Material Icons](https://fonts.google.com/icons)
2. [Font Awesome](https://fontawesome.com/)
3. [Icons8](https://icons8.com/)
4. [The Noun Project](https://thenounproject.com/)
5. [Material Icons](https://material.io/resources/icons/)
6. [Bootstrap Icons](https://icons.getbootstrap.com/)


### 1. 폰트 리소스 추가

#### 1-1. 폰트 파일 준비
먼저, 사용할 폰트 파일(`.ttf` 또는 `.otf` 형식)을 준비합니다.

#### 1-2. 폰트 파일을 프로젝트에 추가
1. 안드로이드 스튜디오에서 프로젝트를 엽니다.
2. `res` 폴더 아래에 `font` 폴더를 만듭니다. 만약 `font` 폴더가 없으면 `res` 폴더를 마우스 오른쪽 버튼으로 클릭하고 `New > Android Resource Directory`를 선택하여 `font` 디렉토리를 만듭니다.
3. 준비한 폰트 파일을 `res/font` 폴더에 복사합니다. 예를 들어, `my_custom_font.ttf` 파일을 추가합니다.

### 1-3. XML 레이아웃 파일에서 폰트 리소스 사용
```xml
    <TextView
        android:text="Hello, World!"
        android:fontFamily="@font/my_custom_font" />
```


### 플랫폼 리소스

- 플랫폼 리소스의 종류

1. 시스템 아이콘 (System Icons):
    - 안드로이드는 다양한 기본 아이콘을 제공합니다. 이 아이콘들은 `android.R.drawable` 클래스를 통해 접근할 수 있습니다.

2. 기본 색상 (Default Colors):
    - 시스템에서 제공하는 기본 색상들은 `android.R.color`를 통해 사용할 수 있습니다.

3. 기본 문자열 (Default Strings):
    - 예를 들어, 'OK'와 'Cancel' 같은 기본 문자열은 `android.R.string`을 통해 접근할 수 있습니다.

4. 기본 스타일과 테마 (Default Styles and Themes):
    - 안드로이드는 미리 정의된 스타일과 테마를 제공합니다. 이들은 `android.R.style`과 `android.R.theme`을 통해 사용할 수 있습니다.

### 플랫폼 리소스 사용 예시

- 시스템 아이콘 사용하기
  레이아웃 파일에서 시스템 아이콘 사용하기:
```xml
<ImageView
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:src="@android:drawable/ic_delete" />
```
- `ic_delete`는 안드로이드 시스템에서 제공하는 삭제 아이콘입니다.

#### 기본 색상 사용하기
XML에서 기본 색상 참조하기:
```xml
<TextView
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:textColor="@android:color/holo_blue_bright" />
```
- `holo_blue_bright`는 안드로이드가 제공하는 표준 색상 중 하나입니다.

#### 기본 문자열 사용하기
```kotlin
val okString = getString(android.R.string.ok)
```
- 이 코드는 프로그래밍적으로 'OK' 문자열을 가져옵니다.


### 리소스 조건

- 리소스 한정자 별 조건 종류 (아래 공식문서 확인)
- [공식문서 : 리소스 조건 및 한정자 사용하기](https://developer.android.com/guide/topics/resources/providing-resources?hl=ko#QualifierRules)



### 예시 설명

1. 화면 방향:
    - 기본 세로 모드와 가로 모드에서 각각 다른 레이아웃을 사용합니다.
    - `res/layout/activity_main.xml`
    - `res/layout-land/activity_main.xml`

2. 화면 크기:
    - 작은 화면, 일반 화면, 큰 화면, 매우 큰 화면에서 각각 다른 레이아웃을 사용합니다.
    - `res/layout/activity_main.xml`
    - `res/layout-large/activity_main.xml`

3. 화면 밀도:
    - 다양한 화면 밀도에 따라 다른 이미지를 사용합니다.
    - `res/drawable-mdpi/icon.png`
    - `res/drawable-hdpi/icon.png`

4. 언어 및 지역:
    - 다국어 지원을 위해 언어별로 다른 문자열 리소스를 사용합니다.
    - `res/values/strings.xml`
    - `res/values-ko/strings.xml`

5. API 레벨:
    - 특정 API 레벨 이상에서 다른 리소스를 사용합니다.
    - `res/values/styles.xml`
    - `res/values-v21/styles.xml`


### 화면 회전 대응하기

-  레이아웃 파일을 적절한 위치에 배치하여 화면 회전에 따라 다른 레이아웃을 사용할 수 있습니다.

- 세로 모드 레이아웃 파일: res/layout/activity_main.xml
- 가로 모드 레이아웃 파일: res/layout-land/activity_main.xml

### 국제 언어 제공하기

1. 기본 문자열 리소스 정의: `res/values/strings.xml` 파일에 기본 언어로 사용할 문자열을 정의합니다.

2. 다국어 문자열 리소스 추가: `res/values-<language>` 폴더에 해당 언어로 사용할 문자열을 정의합니다. 예를 들어, 한국어는 `res/values-ko/strings.xml` 파일을 사용합니다.

    1. res/values 디렉터리를 마우스 오른쪽 버튼으로 클릭하고, New > Values Resource File을 선택합니다.
    2. 리소스 파일 생성 : 파일 이름에 strings.xml을 입력하고, Available qualifiers에서 Locale을 선택한 뒤, 오른쪽 화살표 버튼(>>)을 클릭합니다.
    3. 언어 및 지역 선택 Language에서 ko: Korean을 선택하고, Specific Region Only에서 KR: South Korea를 선택한 후, OK 버튼을 클릭합니다.

3. 레이아웃 파일에서 문자열 리소스 참조: 레이아웃 파일에서 `@string` 리소스를 참조합니다.

4. 시스템 언어 변경하여 테스트: 에뮬레이터 또는 실제 기기에서 시스템 언어를 변경하고, 앱이 해당 언어로 표시되는지 확인합니다.


### 에뮬레이터 시스템 설정 변경하기

1. 에뮬레이터 실행: 안드로이드 스튜디오에서 AVD Manager를 통해 에뮬레이터를 실행합니다.
2. 시스템 설정 열기: 에뮬레이터에서 'Settings' 앱을 엽니다.
3. 언어 및 입력 설정: 'System' > 'Languages & input' > 'Languages'로 이동합니다.
4. 언어 추가 및 순서 변경: 원하는 언어를 추가하고, 기본 언어로 설정합니다.
5. 설정 변경 확인: 시스템 텍스트와 앱의 언어가 변경된 것을 확인합니다.


### 기기호환성과 픽셀 단위

#### DP (Density-Independent Pixels)
- 정의: `dp`는 픽셀 밀도에 독립적인 단위로, 물리적 크기가 일관되게 유지되도록 설계되었습니다. 기본적으로, 160 DPI (dots per inch) 화면에서 1dp는 1px과 같습니다.
- 사용 목적: `dp`는 대부분의 UI 레이아웃 요소에 사용됩니다 (예: 마진, 패딩, 뷰의 크기 등). 이를 사용하면 다양한 해상도를 가진 디바이스에서도 비슷한 물리적 크기를 유지할 수 있습니다.

#### SP (Scale-Independent Pixels)
- 정의: `sp`는 `dp`와 유사하되, 사용자가 설정한 글꼴 크기 확대/축소에 따라 조절될 수 있는 단위입니다.
- 사용 목적: 주로 텍스트의 크기 설정에 사용됩니다. 사용자의 접근성 설정에 따라 텍스트가 자동으로 확대 또는 축소되어야 할 때 유용합니다. 이는 시각 장애가 있는 사용자에게 특히 중요할 수 있습니다.

- [가이드:다양한 픽셀 밀도 지원](https://developer.android.com/training/multiscreen/screendensities?hl=ko)
- [XML로 정의된 크기 단위](https://developer.android.com/guide/topics/resources/more-resources#Dimension)


### 기기 크기 확인하기
```kt
        // 기기의 가로 세로 크기 가져오기
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            // API 버전 30 이상인 경우
            val windowMetrics = windowManager.currentWindowMetrics
            val width = windowMetrics.bounds.width()
            val height = windowMetrics.bounds.height()
            Log.d("mylog", "기기 너비 : $width, 기기 높이 : $height")
        } else {
            // API 버전 30 이하인 경우
            val display = windowManager.defaultDisplay
            val displayMetrics = DisplayMetrics()
            display.getRealMetrics(displayMetrics)

            val width = displayMetrics.widthPixels
            val height = displayMetrics.heightPixels
            Log.d("mylog", "기기 너비 : $width, 기기 높이 : $height")
        }
```

## 권한

### 1. 일반 권한 (Normal Permissions)

일반 권한은 민감하지 않은 데이터와 기능에 접근하는 데 필요한 권한입니다. 이 권한들은 앱 설치 시 자동으로 부여되며, 사용자에게 별도의 허가를 요청하지 않아도 됩니다. 일반 권한은 사용자 개인 정보나 장치 보안에 큰 영향을 미치지 않는 기능에 사용됩니다.

- 예시

- 인터넷 접근 권한 (`INTERNET`)
- 네트워크 상태 확인 권한 (`ACCESS_NETWORK_STATE`)
- Wi-Fi 상태 확인 권한 (`ACCESS_WIFI_STATE`)

- 선언 방법

일반 권한은 `AndroidManifest.xml` 파일에 선언합니다.
예를 들어, 인터넷 접근 권한을 선언하려면 아래와 같이 작성합니다.

```xml
<manifest xmlns:android="<http://schemas.android.com/apk/res/android>"
    package="com.busanit.myfirstapp">

    <uses-permission android:name="android.permission.INTERNET" />

    <!-- Other declarations -->

</manifest>

```

### 2. 위험 권한 (Dangerous Permissions)

위험 권한은 민감한 데이터나 장치 기능에 접근할 때 필요한 권한입니다. 이러한 권한들은 사용자의 개인 정보나 장치 보안에 큰 영향을 미칠 수 있기 때문에, 사용자가 명시적으로 허가해야 합니다. 앱 실행 중에 사용자가 허가를 승인하거나 거부할 수 있습니다.

- 예시

    - 위치 정보 접근 권한 (`ACCESS_FINE_LOCATION`, `ACCESS_COARSE_LOCATION`)
    - 카메라 사용 권한 (`CAMERA`)
    - 연락처 접근 권한 (`READ_CONTACTS`, `WRITE_CONTACTS`)
    - 저장소 접근 권한 (`READ_EXTERNAL_STORAGE`, `WRITE_EXTERNAL_STORAGE`)

### 권한 요청 처리 절차

1. 권한 선언: `AndroidManifest.xml` 파일에 필요한 권한을 선언합니다.
2. 권한 확인: 앱 실행 시 `ContextCompat.checkSelfPermission()` 메서드로 권한을 확인합니다.
3. 권한 요청: 권한이 부여되지 않은 경우 `ActivityCompat.requestPermissions()` 메서드로 사용자에게 권한을 요청합니다.
4. 결과 처리: `onRequestPermissionsResult()` 메서드에서 권한 요청 결과를 처리합니다.

#### 선언 및 요청 방법

1. 권한 선언: `AndroidManifest.xml` 파일에 위험 권한을 선언합니다.

    ```xml
    <manifest xmlns:android="<http://schemas.android.com/apk/res/android>"
        package="com.busanit.myfirstapp">
    
        <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
    
        <!-- Other declarations -->
    
    </manifest>
    
    ```

2. 권한 요청: 앱 실행 중에 권한을 요청합니다. 예를 들어, 위치 권한을 요청하려면 아래와 같이 작성합니다.

    ```kotlin
    import android.Manifest
    import android.content.pm.PackageManager
    import androidx.core.app.ActivityCompat
    import androidx.core.content.ContextCompat
    
    class MainActivity : AppCompatActivity() {
    
        private val LOCATION_PERMISSION_REQUEST_CODE = 1
    
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
    
            // 위치 권한 요청
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
    
                ActivityCompat.requestPermissions(this,
                    arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                    LOCATION_PERMISSION_REQUEST_CODE)
            }
        }
    
        override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults)
            if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    // 권한이 승인된 경우
                    // 위치 정보를 얻는 코드 작성
                    Toast.makeText(this, "위치 권한이 승인되었습니다.", Toast.LENGTH_SHORT).show()
                } else {
                    // 권한이 거부된 경우
                    Toast.makeText(this, "위치 권한이 필요합니다.", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
    
    ```


### 대표적인 안드로이드 시스템 권한

1. 위치 권한 (Location Permissions)
    - `ACCESS_FINE_LOCATION`: GPS를 통해 정확한 위치 정보를 접근할 수 있는 권한
    - `ACCESS_COARSE_LOCATION`: Wi-Fi 및 기지국 정보를 통해 대략적인 위치 정보를 접근할 수 있는 권한
2. 카메라 권한 (Camera Permissions)
    - `CAMERA`: 카메라 하드웨어에 접근하여 사진 및 비디오를 촬영할 수 있는 권한
3. 연락처 권한 (Contacts Permissions)
    - `READ_CONTACTS`: 사용자의 연락처 데이터를 읽을 수 있는 권한
    - `WRITE_CONTACTS`: 사용자의 연락처 데이터를 수정할 수 있는 권한
    - `GET_ACCOUNTS`: 기기에 등록된 계정 목록에 접근할 수 있는 권한
4. 전화 권한 (Phone Permissions)
    - `READ_PHONE_STATE`: 전화 상태와 관련된 정보를 읽을 수 있는 권한
    - `CALL_PHONE`: 전화를 걸 수 있는 권한
    - `READ_CALL_LOG`: 전화 기록을 읽을 수 있는 권한
    - `WRITE_CALL_LOG`: 전화 기록을 수정할 수 있는 권한
    - `ADD_VOICEMAIL`: 음성 메일을 추가할 수 있는 권한
    - `USE_SIP`: SIP 통화를 사용할 수 있는 권한
    - `PROCESS_OUTGOING_CALLS`: 발신 전화를 처리할 수 있는 권한
5. 저장소 권한 (Storage Permissions)
    - `READ_EXTERNAL_STORAGE`: 외부 저장소의 파일을 읽을 수 있는 권한
    - `WRITE_EXTERNAL_STORAGE`: 외부 저장소의 파일을 쓸 수 있는 권한
6. 마이크 권한 (Microphone Permissions)
    - `RECORD_AUDIO`: 마이크를 통해 오디오를 녹음할 수 있는 권한
7. SMS 권한 (SMS Permissions)
    - `SEND_SMS`: SMS 메시지를 보낼 수 있는 권한
    - `RECEIVE_SMS`: SMS 메시지를 받을 수 있는 권한
    - `READ_SMS`: SMS 메시지를 읽을 수 있는 권한
    - `RECEIVE_WAP_PUSH`: WAP 푸시 메시지를 받을 수 있는 권한
    - `RECEIVE_MMS`: MMS 메시지를 받을 수 있는 권한
8. 캘린더 권한 (Calendar Permissions)
    - `READ_CALENDAR`: 사용자의 캘린더 데이터를 읽을 수 있는 권한
    - `WRITE_CALENDAR`: 사용자의 캘린더 데이터를 수정할 수 있는 권한
9. 센서 권한 (Sensors Permissions)
    - `BODY_SENSORS`: 심박수와 같은 신체 센서 데이터를 접근할 수 있는 권한
10. 위치에 따른 네트워크 상태 권한 (Network State Permissions)
    - `ACCESS_NETWORK_STATE`: 네트워크 연결 상태를 확인할 수 있는 권한
    - `ACCESS_WIFI_STATE`: Wi-Fi 연결 상태를 확인할 수 있는 권한
    - `CHANGE_WIFI_STATE`: Wi-Fi 연결 상태를 변경할 수 있는 권한
11. 기타 권한 (Other Permissions)
    - `INTERNET`: 인터넷에 접근할 수 있는 권한
    - `BLUETOOTH`: 블루투스 연결을 사용할 수 있는 권한
    - `BLUETOOTH_ADMIN`: 블루투스 설정을 변경할 수 있는 권한
    - `NFC`: NFC 하드웨어에 접근할 수 있는 권한
    - `VIBRATE`: 장치를 진동시킬 수 있는 권한
    - `WAKE_LOCK`: CPU가 슬립 모드로 들어가지 않도록 할 수 있는 권한

### 공식 문서 참조

- [Permissions Overview](https://developer.android.com/guide/topics/permissions/overview)
- [Requesting Permissions at Run Time](https://developer.android.com/training/permissions/requesting)
- [Manifest.permission](https://developer.android.com/reference/android/Manifest.permission)

---

## 토스트(Toast)

### 1 개요

토스트는 사용자가 명시적으로 닫지 않아도 자동으로 사라지는 짧은 메시지입니다. 주로 간단한 알림이나 상태를 사용자에게 알려주는 데 사용됩니다.

### 2 사용 방법

- 기본 토스트: `Toast.makeText(Context, String, int).show()`
- 위치 변경: `Toast.setGravity(int, int, int)`
- 커스텀 토스트: 사용자 정의 레이아웃 사용

### 3 예제 코드

```kotlin
// 기본 토스트
Toast.makeText(this, "Hello, World!", Toast.LENGTH_SHORT).show()

// 짧은 시간 동안 메시지 표시
Toast.makeText(this, "짧은 시간 동안 표시됩니다.", Toast.LENGTH_SHORT).show()

// 긴 시간 동안 메시지 표시
Toast.makeText(this, "긴 시간 동안 표시됩니다.", Toast.LENGTH_LONG).show()

// 위치 변경
val toast = Toast.makeText(this, "위치가 변경된 토스트입니다.", Toast.LENGTH_SHORT)
toast.setGravity(Gravity.TOP or Gravity.CENTER_HORIZONTAL, 0, 0)
toast.show()

// 커스텀 토스트
val inflater = layoutInflater
val layout = inflater.inflate(R.layout.custom_toast, findViewById(R.id.custom_toast_container))
val customToast = Toast(applicationContext)
customToast.duration = Toast.LENGTH_SHORT
customToast.view = layout
customToast.show()

```

### 4 참고 자료

- [Toast 공식 문서](https://developer.android.com/guide/topics/ui/notifiers/toasts)

---

## 스낵바(Snackbar)

### 1 개요

스낵바는 화면 하단에 표시되는 메시지로, 사용자에게 간단한 알림을 제공하거나 액션을 수행할 수 있는 버튼을 포함할 수 있습니다. 토스트보다 더 많은 기능과 상호작용을 제공합니다.

### 2 사용 방법

- 기본 스낵바: `Snackbar.make(View, String, int).show()`
- 액션 추가: `Snackbar.setAction(String, View.OnClickListener)`
- 스타일 변경: `Snackbar.setActionTextColor(int)` 및 `Snackbar.view.setBackgroundColor(int)`
- 커스텀 스낵바: 사용자 정의 레이아웃 사용

### 3 예제 코드

```kotlin
// 기본 스낵바
Snackbar.make(findViewById(R.id.root_layout), "Hello, Snackbar!", Snackbar.LENGTH_SHORT).show()

// 액션 추가
val snackbar = Snackbar.make(findViewById(R.id.root_layout), "메시지 삭제", Snackbar.LENGTH_LONG)
snackbar.setAction("취소") {
    Toast.makeText(this, "삭제 취소됨", Toast.LENGTH_SHORT).show()
}
snackbar.show()

// 스타일 변경
val styledSnackbar = Snackbar.make(findViewById(R.id.root_layout), "스타일 변경된 스낵바", Snackbar.LENGTH_SHORT)
styledSnackbar.setAction("확인") { }
styledSnackbar.setActionTextColor(Color.YELLOW)
styledSnackbar.view.setBackgroundColor(Color.BLUE)
styledSnackbar.show()

// 커스텀 스낵바 (커스텀 레이아웃)
val customSnackbar = Snackbar.make(findViewById(R.id.root_layout), "", Snackbar.LENGTH_LONG)
val customView = layoutInflater.inflate(R.layout.custom_snackbar, null)
// 기존 텍스트와 액션을 제거하고 커스텀 레이아웃을 설정
val snackbarLayout = customSnackbar.view as Snackbar.SnackbarLayout
snackbarLayout.setPadding(0, 0, 0, 0)
snackbarLayout.addView(customView, 0)
customSnackbar.show()

```

### 4 참고 자료

- [Snackbar 공식 문서](https://developer.android.com/reference/com/google/android/material/snackbar/Snackbar)

---

## 다이얼로그(대화상자, Dialog)

### 1 개요

다이얼로그는 사용자가 상호작용할 수 있는 팝업 창입니다. 정보를 제공하거나 사용자로부터 입력을 받을 수 있습니다. 다양한 종류의 다이얼로그가 있습니다.

### 2 종류 및 사용 방법

- AlertDialog: 간단한 메시지나 선택지를 제공
- DatePickerDialog: 날짜를 선택할 수 있는 다이얼로그
- TimePickerDialog: 시간을 선택할 수 있는 다이얼로그
- ProgressDialog: 진행 상태를 표시 (Deprecated)
- Custom Dialog: 사용자 정의 레이아웃을 사용하는 다이얼로그

### 3 예제 코드

```kotlin
// AlertDialog
val alertDialogBuilder = AlertDialog.Builder(this)
alertDialogBuilder.setTitle("경고")
alertDialogBuilder.setMessage("이 작업을 수행하시겠습니까?")
alertDialogBuilder.setPositiveButton("예") { dialog, which ->
    Toast.makeText(applicationContext, "예를 선택했습니다.", Toast.LENGTH_SHORT).show()
}
alertDialogBuilder.setNegativeButton("아니오") { dialog, which ->
    Toast.makeText(applicationContext, "아니오를 선택했습니다.", Toast.LENGTH_SHORT).show()
}
alertDialogBuilder.show()

// DatePickerDialog
val calendar = Calendar.getInstance()
val datePickerDialog = DatePickerDialog(this, { _, year, month, day ->
    val selectedDate = "$year-${month + 1}-$day"
    Toast.makeText(this, "선택된 날짜: $selectedDate", Toast.LENGTH_SHORT).show()
}, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH))
datePickerDialog.show()

// TimePickerDialog
val timePickerDialog = TimePickerDialog(this, { _, hour, minute ->
    val selectedTime = "$hour:$minute"
    Toast.makeText(this, "선택된 시간: $selectedTime", Toast.LENGTH_SHORT).show()
}, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true)
timePickerDialog.show()

// Custom Dialog  (커스텀 레이아웃)
val customDialogView = layoutInflater.inflate(R.layout.custom_dialog, null)
val customDialog = AlertDialog.Builder(this)
    .setView(customDialogView)
    .create()

customDialogView.findViewById<Button>(R.id.button).setOnClickListener {
    val inputText = customDialogView.findViewById<EditText>(R.id.editText).text.toString()
    Toast.makeText(this, "입력된 값: $inputText", Toast.LENGTH_SHORT).show()
    customDialog.dismiss()
}
customDialog.show()

```

### 4 참고 자료

- [Dialogs 공식 문서](https://developer.android.com/guide/topics/ui/dialogs)

---

## 링톤(Ringtone)

### 1 개요

링톤(Ringtone)은 장치의 기본 알림 소리를 재생하는 기능입니다. 이를 통해 사용자에게 중요한 알림을 소리로 전달할 수 있습니다.

### 2 설정 방법

링톤을 재생하려면 `RingtoneManager` 클래스를 사용합니다. 알림 소리의 URI를 가져와 `Ringtone` 객체를 생성하고, 이를 재생합니다.

### 3 코드 예제

```kotlin
    // 링톤을 재생하는 메서드입니다.
    private fun playRingtone() {
        val soundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION) // 기본 알림 소리의 URI를 가져옵니다.
        val ringtone = RingtoneManager.getRingtone(applicationContext, soundUri) // 알림 소리를 재생하는 Ringtone 객체를 생성합니다.
        ringtone.play() // 알림 소리를 재생합니다.
    }

```

### 4 주요 포인트

- `RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)`을 사용하여 기본 알림 소리의 URI를 가져옵니다.
- `RingtoneManager.getRingtone(context, uri)`을 사용하여 `Ringtone` 객체를 생성합니다.
- `ringtone.play()`를 호출하여 알림 소리를 재생합니다.

---

## 진동(Vibrator)

### 1 개요

진동(Vibrator)은 장치의 진동 기능을 활용하여 사용자에게 알림을 전달하는 기능입니다. 이를 통해 소리 없이도 중요한 알림을 전달할 수 있습니다.

### 2 설정 방법

진동을 발생시키려면 `Vibrator` 클래스를 사용합니다. API 레벨에 따라 `VibratorManager`나 `Vibrator`를 사용하여 진동을 설정할 수 있습니다.

### 3 코드 예제

```kotlin
    // 진동을 발생시키는 메서드입니다.
    private fun vibratePhone() {
        val vibrator = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            val manager = getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as VibratorManager // VibratorManager를 가져옵니다.
            manager.defaultVibrator // 기본 진동기를 가져옵니다.
        } else {
            getSystemService(Context.VIBRATOR_SERVICE) as Vibrator // Vibrator를 직접 가져옵니다.
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            vibrator.vibrate(
                VibrationEffect.createWaveform(longArrayOf(0, 500, 1000, 500), -1) // 진동 패턴 설정
            )
        } else {
            vibrator.vibrate(longArrayOf(0, 500, 1000, 500), -1) // 진동 패턴 설정
        }
    }
```

### 4 주요 포인트

- API 31 이상에서는 `VibratorManager`를 사용하여 진동기를 가져옵니다.
- API 26 이상에서는 `VibrationEffect`를 사용하여 진동 효과를 설정합니다.
- `vibrator.vibrate(longArrayOf(0, 500, 1000, 500), -1)`를 사용하여 진동 패턴을 설정하고 진동을 발생시킵니다.

### 공식 문서

- [RingtoneManager](https://developer.android.com/reference/android/media/RingtoneManager)
- [Ringtone](https://developer.android.com/reference/android/media/Ringtone)
- [Vibrator](https://developer.android.com/reference/android/os/Vibrator)
- [VibrationEffect](https://developer.android.com/reference/android/os/VibrationEffect)
- [VibratorManager](https://developer.android.com/reference/android/os/VibratorManager) (API 31 이상)

## 알림

알림(Notification)을 만드는 순서, 중요도 상수, 채널의 함수, 알림 구성 요소 등을 정리하겠습니다.

### 1. 알림 만드는 순서

1. 알림 채널 생성 (API 26 이상):
    - 알림을 표시하기 위해서는 먼저 알림 채널을 생성해야 합니다.
    - `NotificationChannel` 객체를 생성하고, 이를 `NotificationManager`를 통해 등록합니다.
2. 알림 생성:
    - `NotificationCompat.Builder`를 사용하여 알림을 생성합니다.
    - 알림의 아이콘, 제목, 내용, 우선 순위 등을 설정합니다.
3. 알림 표시:
    - `NotificationManagerCompat`를 사용하여 알림을 표시합니다.
    - `notify` 메서드를 호출하여 알림을 표시합니다.
4. 권한 요청 (API 33 이상):
    - **`POST_NOTIFICATIONS`** 권한을 요청해야 합니다.
    - **`ActivityResultContracts.RequestPermission`**을 사용하여 권한을 요청합니다.

### 2. 채널의 함수

- `createNotificationChannel(channel: NotificationChannel)`:
    - `NotificationManager` 클래스의 메서드로, 알림 채널을 생성합니다.
- `deleteNotificationChannel(channelId: String)`:
    - 지정된 ID의 알림 채널을 삭제합니다.
- `getNotificationChannel(channelId: String)`:
    - 지정된 ID의 알림 채널을 반환합니다.
- `getNotificationChannels()`:
    - 모든 알림 채널의 목록을 반환합니다.

### 3. 알림 구성 요소

- 알림 아이콘 (setSmallIcon):
    - 알림의 아이콘을 설정합니다.
    - 예: `builder.setSmallIcon(R.drawable.ic_notification)`
- 알림 제목 (setContentTitle):
    - 알림의 제목을 설정합니다.
    - 예: `builder.setContentTitle("알림 제목")`
- 알림 내용 (setContentText):
    - 알림의 내용을 설정합니다.
    - 예: `builder.setContentText("이것은 알림 내용입니다.")`
- 알림 우선 순위 (setPriority):
    - 알림의 우선 순위를 설정합니다.
    - 예: `builder.setPriority(NotificationCompat.PRIORITY_DEFAULT)`
- 알림 클릭 시 실행할 인텐트 (setContentIntent):
    - 알림을 클릭했을 때 실행할 인텐트를 설정합니다.
    - 예: `builder.setContentIntent(pendingIntent)`
- 알림 클릭 시 자동 제거 (setAutoCancel):
    - 알림을 클릭했을 때 자동으로 제거되도록 설정합니다.
    - 예: `builder.setAutoCancel(true)`

### 4. 중요도 상수 (Notification Importance Constants)

알림의 중요도를 설정하는 데 사용되는 상수입니다. 중요도에 따라 알림이 사용자에게 표시되는 방식이 달라집니다.

- `NotificationManager.IMPORTANCE_DEFAULT`:
    - 기본 중요도입니다. 알림 소리가 나며, 상태바에 아이콘이 표시됩니다.
- `NotificationManager.IMPORTANCE_HIGH`:
    - 높은 중요도입니다. 알림 소리가 나며, 헤드업 알림으로 표시됩니다.
- `NotificationManager.IMPORTANCE_LOW`:
    - 낮은 중요도입니다. 알림 소리가 나지 않으며, 상태바에만 아이콘이 표시됩니다.
- `NotificationManager.IMPORTANCE_MIN`:
    - 최소 중요도입니다. 알림 소리가 나지 않으며, 상태바에도 아이콘이 표시되지 않습니다.
- `NotificationManager.IMPORTANCE_MAX`:
    - 매우 높은 중요도입니다. 알림 소리가 나며, 전체 화면 알림으로 표시될 수 있습니다.

### 5. 코드 예제

### 5.1 `AndroidManifest.xml` 권한 추가

```xml
<uses-permission android:name="android.permission.POST_NOTIFICATIONS"/>

```

### 5.2  코드

```kotlin
    // 알림 채널을 생성하는 메서드입니다.
    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) { // API 26 이상에서만 NotificationChannel을 설정합니다.
            val channelId = "default_channel_id" // 채널 ID를 설정합니다.
            val channelName = "Default Channel" // 채널 이름을 설정합니다.
            val channelDescription = "This is the default channel for notifications" // 채널 설명을 설정합니다.
            val importance = NotificationManager.IMPORTANCE_DEFAULT // 채널의 중요도를 설정합니다.
            val channel = NotificationChannel(channelId, channelName, importance).apply {
                description = channelDescription // 채널 설명을 설정합니다.
            }

            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager // NotificationManager를 가져옵니다.
            notificationManager.createNotificationChannel(channel) // NotificationChannel을 생성합니다.
        }
    }

    // 알림을 생성하고 표시하는 메서드입니다.
    private fun showNotification() {
        val channelId = "default_channel_id" // 알림 채널 ID를 설정합니다.
        val intent = Intent(this, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK // 인텐트 플래그를 설정합니다.
        }
        val pendingIntent = TaskStackBuilder.create(this).run {
            addNextIntentWithParentStack(intent) // 인텐트를 스택에 추가합니다.
            getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE) // PendingIntent를 생성합니다.
        }

        val builder = NotificationCompat.Builder(this, channelId)
            .setSmallIcon(R.drawable.ic_notification) // 알림 아이콘을 설정합니다.
            .setContentTitle("알림 제목") // 알림 제목을 설정합니다.
            .setContentText("이것은 알림 내용입니다.") // 알림 내용을 설정합니다.
            .setPriority(NotificationCompat.PRIORITY_DEFAULT) // 알림의 우선 순위를 설정합니다.
            .setContentIntent(pendingIntent) // 알림 클릭 시 실행할 인텐트를 설정합니다.
            .setAutoCancel(true) // 알림 클릭 시 자동으로 제거되도록 설정합니다.

        with(NotificationManagerCompat.from(this)) {
            notify(1, builder.build()) // 알림을 표시합니다.
        }
    }
}

```

- 권한요청 코드

```kotlin

        // 권한 요청을 위한 ActivityResultLauncher를 등록합니다.
        val permissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted: Boolean ->
            if (isGranted) {
                showNotification() // 권한이 허용된 경우 알림을 표시합니다.
            } else {
                Toast.makeText(this, "Permission denied...", Toast.LENGTH_SHORT).show() // 권한이 거부된 경우 토스트 메시지를 표시합니다.
            }
        }

        // 버튼 클릭 리스너를 설정합니다.
        binding.button.setOnClickListener {
            // 알림 권한이 있는지 확인합니다.
            if (ContextCompat.checkSelfPermission(
                    this,
                    "android.permission.POST_NOTIFICATIONS"
                ) == PackageManager.PERMISSION_GRANTED) {
                showNotification() // 권한이 허용된 경우 알림을 표시합니다.
            } else {
                permissionLauncher.launch("android.permission.POST_NOTIFICATIONS") // 권한이 허용되지 않은 경우 권한을 요청합니다.
            }
        }
    }
```

### 공식 문서 링크

- Notifications Overview: [Notifications Overview](https://developer.android.com/guide/topics/ui/notifiers/notifications)
- NotificationCompat.Builder: [NotificationCompat.Builder](https://developer.android.com/reference/androidx/core/app/NotificationCompat.Builder)
- NotificationManager: [NotificationManager](https://developer.android.com/reference/android/app/NotificationManager)
- NotificationChannel: [NotificationChannel](https://developer.android.com/reference/android/app/NotificationChannel)

## Jetpack 라이브러리

- Jetpack은 안드로이드 앱 개발을 단순화하고 고품질 앱을 쉽게 만들 수 있도록 도와주는 라이브러리 모음입니다. Jetpack 라이브러리는 코드의 재사용성을 높이고, 보일러플레이트 코드를 줄이며, 앱의 성능과 안정성을 향상시킵니다.
- androidx 네임스페이스는 Android Jetpack 라이브러리로 구성됩니다.
- androidX의 모든 패키지는 androidx라는 문자열로 시작하는 일관된 네임스페이스에 있습니다.
- androidx 네임스페이스에 있는 라이브러리는 지원 라이브러리와 마찬가지로 Android 플랫폼과 별도로 제공되며 Android 출시 버전 전체에서 이전 버전과 호환됩니다.

#### 기본

- AppCompat: 하위 호환성을 제공하여 최신 안드로이드 기능을 모든 버전에서 사용할 수 있게 합니다.
- Android KTX: 코틀린을 위한 확장 기능을 제공하여 코틀린 코드의 가독성과 생산성을 향상시킵니다.

#### UI

- ConstraintLayout: 복잡한 레이아웃을 간단하게 정의할 수 있습니다.
- Fragment: 모듈화된 UI 컴포넌트를 구현합니다.
- RecyclerView: 대량의 데이터를 효율적으로 표시합니다.
- ViewPager2: 스와이프로 넘기는 화면을 구성합니다.
- Drawerlayout: 옆에서 서랍처럼 열리는 화면을 구성합니다.

- 기타 많은 기능을 지원

### Jetpack 라이브러리의 이점

1. 생산성 향상: 보일러플레이트 코드를 줄이고, 개발 속도를 높입니다.
2. 품질 향상: 테스트 가능하고, 유지 보수하기 쉬운 코드를 작성할 수 있습니다.
3. 안정성 향상: 다양한 안드로이드 버전에서 일관된 동작을 보장합니다.
4. 최신 기술: 최신 안드로이드 기능과 디자인 패턴을 쉽게 도입할 수 있습니다.

---

### 참고 자료

- [Android Jetpack 공식 문서](https://developer.android.com/jetpack)
- [Jetpack 컴포넌트 개요](https://developer.android.com/jetpack/androidx)

---

## 안드로이드 테마 설정

테마는 앱의 전체적인 룩앤필을 정의하는 중요한 요소입니다. 색상, 글꼴, 스타일 등을 지정하여 일관된 디자인을 유지할 수 있습니다.

#### 테마 설정 방법

Step 1: 기본 테마 정의

`res/values/styles.xml` 파일에서 기본 테마를 정의합니다.
```xml
<resources>
    <!-- Base application theme -->
    <style name="AppTheme" parent="Theme.AppCompat.Light.DarkActionBar">
        <!-- Customize your theme here -->
        <item name="colorPrimary">@color/colorPrimary</item>
        <item name="colorPrimaryDark">@color/colorPrimaryDark</item>
        <item name="colorAccent">@color/colorAccent</item>
    </style>
</resources>
```

Step 2: 색상 정의

`res/values/colors.xml` 파일에서 테마에 사용할 색상을 정의합니다.
```xml
<resources>
    <color name="colorPrimary">#6200EE</color>
    <color name="colorPrimaryDark">#3700B3</color>
    <color name="colorAccent">#03DAC5</color>
    <color name="colorBackground">#FFFFFF</color>
    <color name="colorText">#000000</color>
</resources>
```

Step 3: 테마 적용

`AndroidManifest.xml` 파일에서 정의한 테마를 앱에 적용합니다.
```xml
<application
    android:theme="@style/AppTheme"
    ... >
    ...
</application>
```

#### 1.3 커스텀 테마 추가

Step 1: 새로운 테마 정의

`res/values/styles.xml` 파일에 커스텀 테마를 추가합니다.
```xml
<resources>
    <!-- Custom theme -->
    <style name="CustomTheme" parent="Theme.AppCompat.Light.DarkActionBar">
        <item name="colorPrimary">@color/colorPrimary</item>
        <item name="colorPrimaryDark">@color/colorPrimaryDark</item>
        <item name="colorAccent">@color/colorAccent</item>
        <item name="android:windowBackground">@color/colorBackground</item>
        <item name="android:textColor">@color/colorText</item>
    </style>
</resources>
```

Step 2: 액티비티에 커스텀 테마 적용

특정 액티비티에 커스텀 테마를 적용하려면 `AndroidManifest.xml` 파일에서 해당 액티비티에 테마를 지정합니다.
```xml
<activity android:name=".CustomActivity"
    android:theme="@style/CustomTheme">
    ...
</activity>
```

#### 테마 컬러 항목

1. colorPrimary
- 적용 위치: 앱의 주요 색상으로, 주로 앱 바(Action Bar), 툴바(Toolbar), 상태바(Status Bar) 등에 사용됩니다.
- 예시: 앱 바의 배경색, 버튼의 기본 색상 등.

2. colorPrimaryDark
- 적용 위치: 앱의 주요 색상이 좀 더 어두운 색상으로, 주로 상태바(Status Bar)와 일부 앱 바(Toolbar)의 배경색으로 사용됩니다.
- 예시: 상태바의 배경색, 앱 바의 어두운 변형.

3. colorAccent
- 적용 위치: 강조 색상으로, 앱 내의 중요한 인터랙티브 요소에 사용됩니다. 버튼, 스위치, 체크박스, 프로그레스 바 등의 강조 색상으로 사용됩니다.
- 예시: 버튼의 강조 색상, 스위치의 활성화 색상, 체크박스의 체크 색상 등.

4. android:windowBackground
- 적용 위치: 앱의 기본 배경 색상으로, 모든 액티비티와 창의 배경색으로 사용됩니다.
- 예시: 액티비티의 기본 배경 색상, 팝업 창의 배경 색상 등.

5. android:textColor
- 적용 위치: 앱의 기본 텍스트 색상으로, 모든 텍스트 뷰(TextView), 버튼(Button) 등의 기본 텍스트 색상으로 사용됩니다.
- 예시: TextView의 텍스트 색상, 버튼의 텍스트 색상 등.

- 기타 등등...

### 참고 자료

- [Android Developers - Styles and Themes](https://developer.android.com/guide/topics/ui/look-and-feel/themes)
- [Material Design - Color](https://material.io/design/color)


---

## App Bar

- AppBar: 앱의 상단에 위치하며, 주로 앱의 제목, 네비게이션 아이콘, 메뉴 등을 포함하는 영역입니다.

- ActionBar: 안드로이드에서 기본적으로 제공되는 상단 바 컴포넌트로, AppCompatActivity에 의해 자동으로 관리됩니다. Activity의 상태 및 주요 기능을 사용자에게 제공하는 역할을 합니다.

    - 제목과 부제목 표시: 현재 화면의 제목과 부제목을 설정할 수 있습니다.
    - 네비게이션 아이콘: 뒤로 가기 또는 홈으로 이동하는 아이콘을 추가할 수 있습니다.
    - 액션 아이템(메뉴 아이템): 자주 사용하는 기능을 빠르게 접근할 수 있도록 메뉴를 추가할 수 있습니다.


- Toolbar: AppBar의 구체적인 구현체로, 앱의 상단 바 역할을 합니다. 더 유연하고 커스터마이징이 가능하여 XML 레이아웃 파일에 직접 추가할 수 있습니다.

---

### 설정

#### Step 1: AppCompatActivity 사용

`AppCompatActivity`를 상속하는 액티비티를 사용하여 Action Bar를 설정합니다.

#### Step 2: 테마 설정

`res/values/styles.xml` 파일에서 앱의 테마를 설정합니다:
```xml
<resources>
    <!-- Base application theme -->
    <style name="AppTheme" parent="Theme.AppCompat.Light.DarkActionBar">
        <!-- Customize your theme here -->
        <item name="colorPrimary">@color/colorPrimary</item>
        <item name="colorPrimaryDark">@color/colorPrimaryDark</item>
        <item name="colorAccent">@color/colorAccent</item>
    </style>
</resources>
```

#### Step 3: 레이아웃 파일 설정

`res/layout/activity_main.xml` 파일을 생성하거나 수정합니다:
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".MainActivity">

    <!-- 다른 UI 요소들을 추가 -->

</LinearLayout>
```

#### Step 4: 액티비티에서 Action Bar 설정

`MainActivity.kt` 파일에서 Action Bar를 설정하고 커스터마이징합니다:
```kotlin
package com.busanit.myapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Action Bar 설정
        supportActionBar?.apply {
            title = "메인 화면" // Action Bar 제목 설정
            subtitle = "서브 타이틀" // Action Bar 부제목 설정
            setDisplayHomeAsUpEnabled(true) // 네비게이션 아이콘 설정
            setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24) // 네비게이션 아이콘 커스터마이징
        }
    }
}
```

---

## 메뉴 항목 추가 및 처리

#### Step 1: 메뉴 리소스 파일 생성

- 메뉴 : 메뉴 항목은 사용자가 특정 작업을 수행할 수 있도록 하는 인터페이스 요소입니다. 메뉴 항목은 보통 액션 바(Action Bar) 또는 툴바(Toolbar)에 표시됩니다.

`res/menu/menu_main.xml` 파일을 생성합니다:
```xml
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android">
    <item
        android:id="@+id/action_settings"
        android:title="Settings"
        android:showAsAction="never"/>
    <item
        android:id="@+id/action_favorite"
        android:icon="@drawable/ic_baseline_favorite_24"
        android:title="Favorite"
        android:showAsAction="ifRoom"/>
</menu>
```

- `showAsAction` 속성
    1. never : 메뉴 항목을 항상 오버플로우 메뉴(더보기 메뉴)에 표시합니다.
    2. ifRoom : 메뉴 항목을 공간이 있을 경우 액션 바나 툴바에 표시하고, 공간이 부족하면 오버플로우 메뉴에 표시합니다.
    3. always : 항상 액션 바나 툴바에 메뉴 항목을 표시합니다. 이 옵션은 남용되지 않아야 하며, 주로 중요한 액션에만 사용해야 합니다.
    4. withText : 아이콘과 함께 텍스트를 표시합니다. 이 옵션은 ifRoom 또는 always와 함께 사용됩니다.
    5. collapseActionView :메뉴 항목이 액션 뷰를 확장 및 축소할 수 있도록 합니다. 주로 검색이나 기타 액션 뷰에 사용됩니다.

#### Step 2: 메뉴 인플레이트

`___Activity.kt` 파일에서 메뉴를 인플레이트하고 항목 클릭 이벤트를 처리합니다:
```kotlin
override fun onCreateOptionsMenu(menu: Menu?): Boolean {
    menuInflater.inflate(R.menu.menu_main, menu)
    return true
}

override fun onOptionsItemSelected(item: MenuItem): Boolean {
    return when (item.itemId) {
        R.id.action_settings -> {
            // 설정 메뉴 클릭 처리
            true
        }
        R.id.action_favorite -> {
            // 즐겨찾기 메뉴 클릭 처리
            true
        }
        android.R.id.home -> {
            // 네비게이션 아이콘 클릭 처리
            finish() // 현재 액티비티 종료
            true
        }
        else -> super.onOptionsItemSelected(item)
    }
}
```


### 참고 자료

- [Android Developers: Menus 추가](https://developer.android.com/develop/ui/views/components/menus?hl=ko)
- [Android ActionBar 사용 가이드](https://developer.android.com/guide/topics/ui/actionbar)
- [Material Design의 App Bar](https://material.io/components/app-bars-top)

## Activity

### 1.  Activity란

Activity는 안드로이드 앱의 화면을 구성하는 기본 단위입니다. 각 Activity는 사용자와 상호작용하는 단일 화면을 나타냅니다.

### 2. Activity 생명 주기(Life Cycle)

Activity는 여러 상태를 거치며, 각각의 상태 전환 시 특정 콜백 메서드가 호출됩니다. 이를 Activity 생명 주기라고 합니다. 생명 주기를 이해하면 효율적으로 리소스를 관리하고 앱의 상태를 제어할 수 있습니다.

### 주요 생명 주기 메서드

1. onCreate()
    - Activity가 처음 생성될 때 호출됩니다.
    - 초기화 작업을 수행합니다. (예: UI 설정, 데이터 바인딩)
2. onStart()
    - Activity가 사용자에게 보이기 시작할 때 호출됩니다.
3. onResume()
    - Activity가 사용자와 상호작용하기 직전에 호출됩니다.
4. onPause()
    - 다른 Activity가 시작되려 할 때 호출됩니다.
    - 데이터 저장 등 필요한 작업을 수행합니다.
5. onStop()
    - Activity가 더 이상 사용자에게 보이지 않을 때 호출됩니다.
6. onDestroy()
    - Activity가 소멸되기 직전에 호출됩니다.

![Activity 생명주기](https://developer.android.com/images/activity_lifecycle.png)

---

### 참고 자료

- [안드로이드 개발자 공식 문서: Activity 생명 주기](https://developer.android.com/guide/components/activities/activity-lifecycle)

---

## 인텐트(Intent)

### 1. 인텐트(Intent)란?

- *인텐트(Intent)는 안드로이드 컴포넌트 간에 작업을 수행하도록 요청하는 메시지 객체입니다. 인텐트는 주로 액티비티(Activity)를 시작하거나, 서비스(Service)를 시작하거나, 브로드캐스트(Broadcast)를 전송할 때 사용됩니다.

### 주요 역할

- 액티비티 전환: 인텐트를 통해 다른 액티비티를 시작할 수 있습니다.
- 데이터 전달: 인텐트를 통해 데이터(예: 문자열, 숫자 등)를 다른 컴포넌트로 전달할 수 있습니다.
- 외부 앱 호출: 인텐트를 통해 다른 앱을 호출할 수 있습니다. 예를 들어, 웹 브라우저를 열거나 연락처 앱을 실행할 수 있습니다.

---

### 2. 명시적 인텐트와 암시적 인텐트

### 명시적 인텐트 (Explicit Intent)

명시적 인텐트는 특정 컴포넌트를 명시적으로 지정하여 작업을 요청합니다. 주로 앱 내부에서 액티비티를 전환할 때 사용됩니다.

### 예시

```kotlin
// 명시적 인텐트를 사용하여 SecondActivity 시작
val intent = Intent(this, SecondActivity::class.java)
startActivity(intent)

```

### 암시적 인텐트 (Implicit Intent)

암시적 인텐트는 요청할 작업의 일반적인 정보를 제공하고, 이를 처리할 수 있는 컴포넌트를 시스템이 선택합니다. 주로 외부 앱과의 통신이나 특정 작업을 수행할 수 있는 앱을 호출할 때 사용됩니다.

### 예시

```kotlin
// 암시적 인텐트를 사용하여 웹 브라우저에서 URL 열기
val intent = Intent(Intent.ACTION_VIEW, Uri.parse("<https://www.example.com>"))
startActivity(intent)

```

## Context

### Context에 대해 설명

Context는 안드로이드 애플리케이션의 중요한 클래스 중 하나로, 애플리케이션의 환경 정보를 제공하는 인터페이스입니다. Context는 애플리케이션의 다양한 리소스, 애플리케이션 전역의 정보 및 특정 작업을 수행할 수 있는 기능을 제공합니다.

### Context의 종류

안드로이드에서는 여러 종류의 Context가 있습니다.

1. Application Context
    - 애플리케이션의 수명 주기와 동일한 Context입니다.
    - 애플리케이션 전역에서 사용할 수 있으며, 일반적으로 애플리케이션의 수명 동안 유지됩니다.

2. Activity Context
    - 특정 액티비티의 수명 주기와 동일한 Context입니다.
    - Activity가 파괴되면 이 Context도 함께 파괴됩니다.

3. Service Context
    - 특정 서비스의 수명 주기와 동일한 Context입니다.


### Context의 주요 역할

1. 리소스 접근: 앱의 리소스에 접근할 수 있도록 합니다. (예: 문자열, 이미지, 레이아웃 등)
2. 애플리케이션 레벨 작업 수행: 애플리케이션 레벨의 작업을 수행하는 데 사용됩니다. (예: 시작, 중지 서비스, 브로드캐스트 수신 등)
3. 앱 컴포넌트 관리: 애플리케이션의 컴포넌트(Activity, Service, BroadcastReceiver, ContentProvider)에 대한 정보와 접근을 제공합니다.
4. 시스템 서비스 접근: 시스템 서비스(예: WINDOW_SERVICE, LAYOUT_INFLATER_SERVICE 등)에 접근할 수 있도록 합니다.

### Context의 주요 메서드

#### 리소스 접근
- `getResources()`: 앱의 리소스에 접근합니다.
- `getString(R.string.example)`: 문자열 리소스를 가져옵니다.
- `getDrawable(R.drawable.example)`: drawable 리소스를 가져옵니다.

#### 애플리케이션 레벨 작업
- `startActivity(Intent)`: 새로운 액티비티를 시작합니다.
- `startService(Intent)`: 서비스를 시작합니다.
- `stopService(Intent)`: 서비스를 중지합니다.
- `sendBroadcast(Intent)`: 브로드캐스트를 보냅니다.

### 자주 사용하는 암시적 Intent 상수들

| 상수 (Constant)                  | 설명 (Description)                                      |
|----------------------------------|---------------------------------------------------------|
| `Intent.ACTION_VIEW`             | 주어진 URI에 대한 데이터를 보기          |
| `Intent.ACTION_SEND`             | 데이터를 다른 애플리케이션으로 보내기     |
| `Intent.ACTION_SENDTO`           | 특정 주소로 이메일을 보내기             |
| `Intent.ACTION_PICK`             | 데이터를 선택하기                       |
| `Intent.ACTION_DIAL`             | 전화 다이얼을 열기                      |
| `Intent.ACTION_CALL`             | 직접 전화를 걸기 (권한 필요)             |
| `Intent.ACTION_EDIT`             | 데이터를 편집하기                       |
| `Intent.ACTION_DELETE`           | 데이터를 삭제하기                       |
| `Intent.ACTION_GET_CONTENT`      | 사용자에게 데이터를 선택하도록 허용합니다.               |
| `Intent.ACTION_IMAGE_CAPTURE`    | 카메라 앱을 열어 사진을 찍기            |
| `Intent.ACTION_VIDEO_CAPTURE`    | 카메라 앱을 열어 동영상을 찍기          |
| `Intent.ACTION_VIEW_DOWNLOADS`   | 다운로드한 파일을 보기                  |
| `Intent.ACTION_APPLICATION_DETAILS_SETTINGS` | 앱의 설정 화면을 열기        |
| `Intent.ACTION_SETTINGS`         | 설정 화면을 열기                        |
| `Intent.ACTION_WEB_SEARCH`       | 웹 검색을 시작하기                      |