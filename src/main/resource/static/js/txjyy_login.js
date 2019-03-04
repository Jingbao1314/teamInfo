//验证码函数
window.onload=function(){
    var _yanzhengma=document.getElementById("yanzhengma");
    getRandomMath(_yanzhengma);
    var _random=null;
    var loginform=document.getElementById("loginform");
    var indexVlaue=null;

};
//随机颜色函数
function getRandomColor(){
    return '#'+(function(h){
        return new Array(7-h.length).join("0")+h
    })((Math.random()*0x1000000<<0).toString(16));
}
//随机数
function getRandomMath(obj){
    _random=Math.floor(Math.random()*(99999-10000)+10000);
    var _arryanzhengma=(String)(_random).split("");
    obj.innerHTML="";
    for(var i=0;i<_arryanzhengma.length;i++){
        //追加的形式添加
        var _nodeChild=document.createElement("i");
        _nodeChild.style.color=getRandomColor();
        _nodeChild.innerHTML=_arryanzhengma[i]+"&nbsp;";
        obj.appendChild(_nodeChild);
    }
}
//表单前端验证
function formCheck(){
    var username=loginform.username;
    var password=loginform.password;
    var useryanzhengma=loginform.useryanzhengma;
    var username_value=username.value;
    var password=password.value;
    var useryan_value=useryanzhengma.value;
    var tip_info=document.getElementById("error-tip");
    if(username_value.trim()===""){
        tip_info.style="text-indent:7px;color:red;";
        tip_info.innerHTML="<img width='18' height='18' alt='' th:src='@{/images/cuowu.png}'/>对不起用户名不能为空";
        return false;
    }else{
        tip_info.innerHTML="";
    }
    if(password.trim()===""){
        tip_info.style="text-indent:7px;color:red;";
        tip_info.innerHTML="<img width='18' height='18' alt='' th:src='@{/images/cuowu.png}'/>对不起用户密码不能为空";
        return false;
    }else{
        tip_info.innerHTML="";
    }
    if(useryan_value.trim()===""){
        tip_info.style="text-indent:7px;color:red;";
        tip_info.innerHTML="<img width='18' height='18' alt='' th:src='@{/images/cuowu.png}'/>对不起验证码不能为空";
        return false;
    }else{
        if(useryan_value.trim()!=_random){
            tip_info.style="text-indent:7px;color:red;";
            tip_info.innerHTML="<img width='18' height='18' alt='' th:src='@{/images/cuowu.png}'/>对不起验证码输入错误";
            return false;
        }else{
            tip_info.innerHTML="";
        }
    }
    tip_info.innerHTML="";
    return true;
    /**此处到时候转后台查询，如果查询到，则登录成功页面，没查询到，一样返回数据设置对不起用户不存在*/
}
//提交表单
function submitForm(){
    if(formCheck()){
        var username=loginform.username.value;
        var password=loginform.password.value;

        var xmlhttp;
        if (window.XMLHttpRequest)
        {// code for IE7+, Firefox, Chrome, Opera, Safari
            xmlhttp=new XMLHttpRequest();
        }
        else
        {// code for IE6, IE5
            xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
        }
        xmlhttp.onreadystatechange=function()
        {
            if (xmlhttp.readyState===4 && xmlhttp.status===200)
            {
                alert(xmlhttp.responseText);
                if(xmlhttp.responseText){

                }
                else {
                    alert("用户名或密码错误,请重试!")
                }
            }
        };
        // xmlhttp.open("GET","http://127.0.0.1:8080/manager/login?"+"telephoneNumber="+username+"&password="+password);
        // xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
        // xmlhttp.send();
        xmlhttp.open("POST","http://127.0.0.1:8080/manager/login");
        xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
        xmlhttp.send("telephoneNumber="+username+"&password="+password);
    }
}
//获得焦点添加样式,设置传值方式知道是哪一个获得焦点然后再失去焦点的
function addBorder(obj,value){
    //tip_info.innerHTML="";
    var objParent=obj.parentNode;
    objParent.style="border:1px solid blue;";
    objParent.childNodes[1].style="border-right:1px solid blue;";
    indexVlaue=value;
}
//失去焦点
function removeBorder(obj){
    var objParent=obj.parentNode;
    objParent.style="border:1px solid #c6c6c6;";
    objParent.childNodes[1].style="border-right:1px solid #c6c6c6;";
    var tip_info=document.getElementById("error-tip");
    if(indexVlaue==="1"){
        var username_value=loginform.username.value;
        if(username_value.trim()===""){
            tip_info.style="text-indent:7px;color:red;";
            tip_info.innerHTML="<img width='18' height='18' alt='' th:src='@{/images/cuowu.png}'/>对不起用户名不能为空";
            return false;
        }else{
            tip_info.innerHTML="";
        }
    }
    if(indexVlaue==="2"){
        var password=loginform.password.value;
        if(password.trim()===""){
            tip_info.style="text-indent:7px;color:red;";
            tip_info.innerHTML="<img width='18' height='18' alt='' th:src='@{/images/cuowu.png}'/>对不起用户密码不能为空";
            return false;
        }else{
            tip_info.innerHTML="";
        }
    }
    if(indexVlaue==="3"){
        var useryan_value=loginform.useryanzhengma.value;
        if(useryan_value.trim()===""){
            tip_info.style="text-indent:7px;color:red;";
            tip_info.innerHTML="<img width='18' height='18' alt='' th:src='@{/images/cuowu.png}'/>对不起验证码不能为空";
            return false;
        }else{
            if(useryan_value.trim()!==_random){
                tip_info.style="text-indent:7px;color:red;";
                tip_info.innerHTML="<img width='18' height='18' alt='' th:src='@{/images/cuowu.png}'/>对不起验证码输入错误";
                return false;
            }else{
                tip_info.innerHTML="";
            }
        }
    }
}
//记住密码
function remPass(){
    //document.loginform.uname;
    var username=loginform.username;
    var password=loginform.password;
    check=loginform.rempass;
    if(check.checked){
        localStorage.setItem("username",username.value);
        localStorage.setItem("password",password.value);
    }else{
        localStorage.setItem("username","");
        localStorage.setItem("password","");
    }
    localUser = localStorage.getItem("username");
    localPass = localStorage.getItem("password");
    //alert(localUser);
    username.value = localUser;
    password.value = localPass;
    //alert(localPass);
    if(localUser !== "" && localPass !== ""){
        check.setAttribute("checked","");
    }
}
//回车事件
document.onkeydown=function(e){
    if(e.keyCode===13){ // enter 键
        submitForm();
    }
};