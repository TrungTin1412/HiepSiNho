# Ninja Defender

Author: **Phan Trung Tin**

# Git Workflow  
### Initial Setup


1.  Create your branch
```
git checkout -b [yourname]
```
> youname: viết liền ko dấu
> **(chỉ tạo 1 lần duy nhất)**  
2. Push your branch into Github  
```
git push origin [yourname]
```
### Workflow  
1. After completing any feature
```
git add -A 
git commit -m "Message"
git pull origin main
```
2. Resolve conflicts if any, add commit again
3. Push to your branch 
```
git push origin [yourname]
```
4. Go to Github, create Pull request
- Base: main , compare: yourname  

### Review Process  
1. Checkout to the branch which you want to review  
**First time**
```
git checkout main
git pull origin main
git checkout -b [branchname]
```
**Later**
```
git checkout [branchname]
```
2. Pull data from this branch to check
```
git pull origin [branchname]
````
3. Resolve conflicts 
4. Add commit
5. Push data
6. Go to Github -> Request-> Add your Review -> Approve -> Merge










