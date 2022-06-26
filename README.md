# 第7回課題概要

***
## 追加課題
yyyy年mm月dd日以降に産まれた人のデータをまとめて取得する<br>





▼ユーザーデータ<br>
![20220626-01](https://user-images.githubusercontent.com/101798620/175814091-502552c0-3b8c-4c14-bf12-4d3d7b9bf552.png)


▼2000年8月以降に生まれた人のデータを取得<br>
年月の指定はURLパラメータで設定(2000-08)<br>
![2022](https://user-images.githubusercontent.com/101798620/175555361-26823d32-24d2-43d0-8134-90046db69bcb.png)

## 追加機能<br>
▼URLパラメータで送られてくるデータが存在しない年月日の場合、エラーを返す。<br>
![20220626-02](https://user-images.githubusercontent.com/101798620/175814153-e71b95ce-5577-4132-a825-1c269f891738.png)
<br>
▼URLパラメータの値が「yyyy-mm-dd」のフォーマット以外の場合、エラーを返す。<br>
![20220626-03](https://user-images.githubusercontent.com/101798620/175814183-44cfd525-2b55-487a-af9f-8007c5239d1a.png)
<br>


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
