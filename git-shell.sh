git log --oneline --decorate --graph --all

git push -u origin master


提交代码过程：   这里用到了变基方式

	git checkout dev

	git rebase master

	git checkout master

	git merge dev

	最后 git push -u origin master

