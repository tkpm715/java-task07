# 第7回課題概要

***
## 追加課題
URLパラメータからユーザ名と生年月日を受け取り、下記条件に合致する場合はそのJsonデータを返す。
<br>
・生年月日が１９００年からシステム年であること<br>
・生年月日の入力フォーマットが「yyyy-mm-dd」であること<br>
<br>
条件に合致しない場合はエラーメッセージを返す。<br><br>
受け取った生年月日データはBirthdayクラスに渡し、そのクラス内で正常データか否か検証する（ValueObject）

### ▼データ正常時<br>
![20220705-task07-03](https://user-images.githubusercontent.com/101798620/177292266-a40076e6-aedb-4e8c-b72d-12adf08bdcbe.png)

### ▼生年月日が1900年より以前の場合<br>
![20220705-task07-01](https://user-images.githubusercontent.com/101798620/177292612-9bfa76f2-dac0-46d2-97bd-6e8d4cec593f.png)

### ▼生年月日がシステム年より以降の場合<br>
![20220705-task07-05](https://user-images.githubusercontent.com/101798620/177293162-d34c9462-8c50-4f5b-8181-0ea8d487ca3f.png)

### ▼存在しない生年月日データを受け取った場合<br>
![20220705-task07-02](https://user-images.githubusercontent.com/101798620/177292921-6755dbc1-146b-4f05-a156-05bb8be748b4.png)

### ▼生年月日のフォーマットが正しくない場合<br>
![20220706-task07-00](https://user-images.githubusercontent.com/101798620/177534731-af407868-607e-4769-9919-6f03fe468865.png)
***
## 第７回課題内容
HTTPメソッドのGET/POST/PATCH/DELETEのリクエストを扱えるControllerを実装。<br>
オリジナルの仕様として生年月日を受け取れるように実装

### 各HTTPメソッドのリクエスト結果

### GET
![01get](https://user-images.githubusercontent.com/101798620/175304297-99aae540-39f2-42ad-896c-697fa7e277b0.png)

### POST
![02post](https://user-images.githubusercontent.com/101798620/175304435-8965c225-0cbe-456b-b6b6-2597e1517ec6.png)


### PATCH
![03patch](https://user-images.githubusercontent.com/101798620/175304696-1f11f840-149e-4a88-a13e-f743fef2d14a.png)


### DELETE
![04delete](https://user-images.githubusercontent.com/101798620/175304762-ae363716-72a1-41de-abd8-ddc4d4f3ed93.png)
