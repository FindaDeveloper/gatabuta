# 가타부타
```
가타부타 - 어떤 일을 옳다, 그르다 함
```
가타부타는 안드로이드 LiveData 테스트를 쉽고 빠르게 작성할 수 있도록 지원합니다.  
테스트를 작성할 때 프로그래머가 고려할 부분을 최대한 배제할 수 있도록 기능을 향상하고 있습니다.  

가타부타를 사용하기 전에 [Unit-testing LiveData and other common observability problems](https://medium.com/androiddevelopers/unit-testing-livedata-and-other-common-observability-problems-bb477262eb04)를 참고하는 것을 권장드립니다.
가타부타는 내부적으로 LiveData에서 값을 얻기 위해서 해당 글의 내용을 참고했습니다.

### 기능
``` kotlin
/**
 * 현재 LiveData의 값을 얻어옵니다.
 * LiveData가 관찰되지 않아 값을 항상 null을 반환하는 경우(Transformations, MediatorLiveData 등)를
 * 내부적으로 처리하여 항상 정상적인 데이터를 기대할 수 있습니다.
 */
liveData.test.value

liveData.test equalTo "value" // assertEquals("value", liveData.test.value)
liveData.test notEqualTo "value" // assertNotEquals("value", liveData.test.value)

/**
 * LiveData의 값이 설정되지 않으면 내부적으로 TimeoutException을 던집니다.
 * hasValue, hasNoValue는 해당 예외가 여부에 따라 동작합니다.
 */
liveData.test.hasValue() 
liveData.test.hasNoValue()

/**
 * liveData.test.value의 반환형은 null을 허용하지 않습니다.
 * 만약 value의 값이 null이라면 NullLiveDataException을 던집니다.
 * isNull, isNotNull은 해당 예외 여부에 따라 동작합니다
 */
liveData.test.isNull()
liveData.test.isNotNull()
 
/**
 * Collections
 */
collectionLiveData.test hasSize 4 // assertEquals(4, collectionLiveData.test.value.size)
collectionLiveData.test.isEmpty()
collectionLiveData.test.isNotEmpty()

/**
 * Booleans
 */
boolLiveData.test.isTrue()
boolLiveData.test.isFalse()

/**
 * CharSequences
 */ 
charSequencesLiveData.test.hasLength 4
charSequencesLiveData.test.isBlank()
charSequencesLiveData.test.isEmpty()
```

### Download [![](https://jitpack.io/v/kimdohun0104/gatabuta.svg)](https://jitpack.io/#kimdohun0104/gatabuta)
``` groovy
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}

dependencies {
  testImplementation 'com.github.kimdohun0104:gatabuta:$gatabuta_version'
}
```

### License
```
MIT License

Copyright (c) 2020 kimdohun0104

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
