function insertSociety() {
    var id=society.id.value;
    var name=society.name.value;
    var image=society.image.value;
    var introduction=society.introduction.value;

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
            alert("添加成功!");
            society.id.value="";
            society.name.value="";
            society.image.value="";
            society.introduction.value="";
        }
    };
    xmlhttp.open("POST","http://localhost:8080/colorfulsociety/societyInsert",true);
    xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    xmlhttp.send("id="+id+"&name="+name+"&image="+image+"&introduction="+introduction);
}

function insertDownload(){
    var path=download.path.value;
    var name=download.name.value;
    var description=download.description.value;

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
            alert("添加成功!");
            download.path.value="";
            download.name.value="";
            download.description.value="";

        }
    };
    xmlhttp.open("POST","http://localhost:8080/colorfulsociety/downloadInsert",true);
    xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    xmlhttp.send("path="+path+"&name="+name+"&description="+description);
}

function insertActivity() {
    var activityId=activity.activityId.value;
    var name=activity.name.value;
    var starttime=activity.starttime.value;
    var endtime=activity.endtime.value;
    var introduction=activity.introduction.value;
    var societyId=activity.societyId.value;

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
            alert("添加成功!");

            activity.id.value="";
            activity.name.value="";
            activity.starttime.value="";
            activity.endtime.value="";
            activity.introduction.value="";
            activity.societyId.value="";

        }
    };
    xmlhttp.open("POST","http://localhost:8080/colorfulsociety/activityInsert",true);
    xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    xmlhttp.send("starttime="+starttime+"&name="+name+"&endtime="+endtime+"&introduction="+introduction+"&societyBelong="+societyId+"&activityId="+activityId);
}

function insertSocietyManagers() {
    var studentId=insertSocietyManager.studentId.value;
    var societyId=insertSocietyManager.societyId.value;

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
            alert("添加成功!");
            insertSocietyManager.societyId.value="";
            insertSocietyManager.studentId.value="";
        }
    };
    xmlhttp.open("POST","http://localhost:8080/colorfulsociety/insertSocietyManager",true);
    xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    xmlhttp.send("studentId="+studentId+"&societyId="+societyId);
}

function deleteSociety() {
    var societyId=society.societyId.value;

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
            alert("删除成功!");
            society.societyId.value="";
        }
    };
    xmlhttp.open("POST","http://localhost:8080/colorfulsociety/societyDelete",true);
    xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    xmlhttp.send("societyId="+societyId);
}