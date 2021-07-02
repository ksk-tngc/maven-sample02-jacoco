my-java-maven-jacoco-sample

## 概要

[JaCoCo](https://www.eclemma.org/jacoco/trunk/index.html) でコードカバレッジのレポートを出力するサンプルです。  
JUnit のテストケースに対する「命令網羅率」(C0レベルカバレッジ) ・「分岐網羅率」(C1レベルカバレッジ) が確認できます。

レポートイメージ  
<img src="https://user-images.githubusercontent.com/59589496/124285475-e93c2400-db88-11eb-942a-cd3543598294.png" width="90%">  
<img src="https://user-images.githubusercontent.com/59589496/124286075-88611b80-db89-11eb-9a7d-9db615e2d605.png" width="90%">  
<img src="https://user-images.githubusercontent.com/59589496/124287047-8b104080-db8a-11eb-9386-e0741f9ca0af.png" width="90%">  

JUnit テストケース  
<img src="https://user-images.githubusercontent.com/59589496/124289491-58b41280-db8d-11eb-8ee5-98aa47efd7ed.png" width="90%">  

レポートは `target/site/jacoco/` に出力されています。

## Dependency

- junit 4.11
- jacoco-maven-plugin 0.8.7

## コマンド

JaCoCo のレポートは以下のコマンドで出力できます。

```
$ mvn jacoco:prepare-agent test jacoco:report
```
