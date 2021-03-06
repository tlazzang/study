#### 연결리스트(Linked List)란 무엇인가?
- 연결리스트는 데이터의 집합을 저장하기 위해 사용되는 데이터 구조

#### 연결리스트의 속성
- 연속되는 항목들이 포인터로 연결된다.
- 마지막 항목은 NULL을 포인트한다.
- 프로그램이 수행되는 동안 크기가 커지거나 작아질 수 있다.
- (시스템 메모리가 허용하는 한) 필요한 만큼 길어질 수 있다.
- 메모리 공간을 낭비하지 않는다(하지만 포인터를 위한 추가의 메모리를 필요로 한다).

#### 연결리스트 ADT(Abstract Data Type)
- 연결 리스트의 주요 연산들
 - 삽입: 항목을 리스트에 추가한다.
 - 삭제: 지정된 위치의 항목을 리스트로부터 삭제하며 리턴한다.

- 연결 리스트의 보조적 연산들
 - 리스트 삭제: 리스트의 모든 항목을 삭제한다(리스트도 삭제)
 - 개수 세기: 리스트의 항목의 개수를 리턴한다.
 - 리스트의 n번째 항목 찾기 등

#### 왜 연결 리스트를 사용하는가?
- 연결 리스트와 배열의 차이점을 이해하는 것이 중요하다.
- 연결 리스트와 배열 모두 데이터 집합을 저장하기 위해 사용된다.
- 어떤 경우에 연결 리스트가 적합하고 어떤 경우에 배열이 적합한지 구분해야 한다.

#### 배열 개요
배열의 항목을 저장하기 위해 메모리 블록 하나가 할당된다. 배열의 항목은 특정 항목의 인덱스를 첨자로 사용하여 일정한 시간으로 접근할 수 있다.

#### 배열의 항목에 접근하는 데 왜 일정한 시간이 걸리는가?
배열의 항목에 접근하기 위해서는 항목의 주소가 배열의 기본주소로부터의 오프셋으로 계산된다. 처음에 데이터형에 따른 항목의 크기가 계산되고, 그것이 항목의 인덱스에 곱해져서 오프셋이 된다.
이 과정에 한 번의 곱셈과 한번의 덧셈이 필요하다. 이 두 연산이 일정한 시간이 걸리므로 배열 접근은 일정한 시간으로 수행된다고 할 수 있다.

#### 배열의 장점
- 간단하고 사용이 쉽다
- 특정 항목에의 접근이 더 빠르다(상수시간)

#### 배열의 단점
- 고정된 크기: 배열의 크기는 정적이다(사용하기 전에 배열의 크기를 정해야 한다)
- 한 블록의 할당: 처음에 배열을 할당할 때 전체 배열을 위한 메모리를 얻지 못할 때도 있다(배열 크기가 클 경우)
- 복잡한 위치 기반의 삽입: 주어진 위치에 항목을 삽입하려면 기존의 항목들을 이동해야 할 수 있다.