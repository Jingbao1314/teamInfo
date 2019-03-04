function updateActivity() {
    var id=activity.id.value;
    var name=activity.name.value;
    var starttime=activity.starttime.value;
    var endtime=activity.endtime.value;
    var introduction=activity.introduction.value;

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
        if (xmlhttp.readyState==4 && xmlhttp.status==200)
        {
            alert("修改成功!");
            activity.id.value="";
            activity.name.value="";
            activity.starttime.value="";
            activity.endtime.value="";
            activity.introduction.value=""

        }
    };
    xmlhttp.open("POST","http://localhost:8080/colorfulsociety/activityUpdate",true);
    xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    xmlhttp.send("starttime="+starttime+"&name="+name+"&endtime="+endtime+"&introduction="+introduction+"&id="+id);
}

function updateNotice() {
    var id=notice.id.value;
    var title=notice.title.value;
    var text=notice.text.value;

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
        if (xmlhttp.readyState==4 && xmlhttp.status==200)
        {
            alert("修改成功!");
            notice.id.value="";
            notice.title.value="";
            notice.text.value="";

        }
    };
    xmlhttp.open("POST","http://localhost:8080/colorfulsociety/noticeUpdate",true);
    xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    xmlhttp.send("title="+title+"&text="+text+"&id="+id);
}