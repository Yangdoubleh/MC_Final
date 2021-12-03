<h1> github 사용법
</h1>

<h3> branch 만드는법
    
</h3>

```bash
git remote update //git remote 갱신
```

branch 이름에는 본인 아이디를 사용



<h5> 원격저장소 branch 가져오기

```bash
git branch -r //원격저장소의 branch리스트 확인
git branch -a //로컬,원격저장소의 모든 branch리스트 확인
git checkout -t origin/(branch이름) //원격저장소의 branch 가져오는 기능 [branch이름은 본인 ID사용]
```



<h5> branch에서 작업하기

꼭 본인의 branch로 이동해서 add, commit push 작업을 실행할 것

```bash
git checkout (branch이름)//본인 branch로 이동
git add .
git commit -m '20211203_yhh_1'//commit메세지는 날짜_본인이름이니셜_1,2,3... 순서대로간다.
git push origin (branch이름)
```

