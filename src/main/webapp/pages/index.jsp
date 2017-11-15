<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String contextPath = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + contextPath;%>
<html lang="en">
<!--<![endif]-->
<head>
    <meta charset="utf-8"/>
    <title>Home</title>
    <jsp:include page="../pages/support/easyui_support.jsp"></jsp:include>
    <meta content="width=device-width, initial-scale=1.0" name="viewport"/>
    <meta name="MobileOptimized" content="320"/>
    <!--srart theme style -->
    <link rel="stylesheet" type="text/css" href="../js/home/css/animate.css">
    <link rel="stylesheet" type="text/css" href="../js/home/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="../js/home/css/font-awesome.css">
    <link rel="stylesheet" type="text/css" href="../js/home/css/owl.carousel.css">
    <link rel="stylesheet" type="text/css" href="../js/home/css/owl.theme.default.css">
    <link rel="stylesheet" type="text/css" href="../js/home/css/magnific-popup.css">
    <link rel="stylesheet" type="text/css" href="../js/home/css/fonts.css">
    <link rel="stylesheet" type="text/css" href="../js/home/css/style.css">
</head>
<body>
<!-- preloader Start -->
<div id="preloader">
    <div id="status"><img src="../js/home/images/header/preloader.gif" id="preloader_image" alt="loader">
    </div>
</div>
<!-- Header Wrapper Start -->
<div section-scroll='0' class="wd_scroll_wrap">
    <div class="wd_slider_wrapper wd_single_index_menu">
        <div id="snow"></div>
        <div class="wd_header_wrapper">
            <div class="col-lg-3 col-md-12 col-sm-12 col-xs-12">
                <div class="wd_logo">
                    <img src="../js/home/images/header/logo.png" alt="Logo" title="Logo" class="img-responsive">
                    <button class="wd_menu_btn"><i class="fa fa-bars" aria-hidden="true"></i></button>
                </div>
            </div>
            <div class="col-lg-9 col-md-12 col-sm-12 col-xs-12">
                <div class="wd_mainmenu_wrapper">
                    <div class="wd_main_menu_wrapper">
                        <div class="wd_main_menu wd_single_index_menu">
                            <ul>
                                <li><a href="0">主页</a></li>
                                <li><a href="1">关于我们</a></li>
                                <li><a href="2">爱情故事</a></li>
                                <li><a href="3">活动</a></li>
                                <li><a href="4">登录</a></li>
                                <li><a href="5">家庭</a></li>
                                <li><a href="6">画廊</a></li>
                                <li><a href="7">纪念</a></li>
                                <li><a href="8">联系我们</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="wd_slider_textinfo">
            <img src="../js/home/images/header/name.png" alt="Slider Image" class="img-responsive">
            <h3>15 Oct 2015</h3>
            <h1>Save The Date</h1>
            <div class="clearfix"></div>
            <img src="../js/home/images/content/heading.png" alt="Heading" class="img-responsive">
        </div>
        <a href="#down" class="smoothScroll" id="headbottom"><i class="fa fa-long-arrow-down"
                                                                aria-hidden="true"></i></a>
    </div>
</div>
<!-- Header Wrapper End -->
<!-- About Wrapper Start -->
<div section-scroll='1' class="wd_scroll_wrap" id="down">
    <div class="wd_about_wrapper wd_toppadder90 wd_bottompadder70">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="wd_heading wow fadeInDown" data-wow-delay="0.3s">
                        <h4>are getting married!</h4>
                        <h1>Groom and Bride</h1>
                        <img src="../js/home/images/content/heading.png" alt="Heading" class="img-responsive">
                    </div>
                </div>
                <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                    <div class="wd_about_infobox wd_toppadder20">
                        <div class="wd_about_infobox_img">
                            <span><img src="../js/home/images/content/line.png" alt="Line"
                                       class="img-responsive"></span>
                            <img src="../js/home/images/content/groom.png" alt="Groom" class="img-responsive">
                        </div>
                        <h2>Mark Wills</h2>
                        <p>(S/o Mrs. Jeniffer & Mr. Clark Wills)</p>
                        <ul>
                            <li><a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a></li>
                            <li><a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a></li>
                            <li><a href="#"><i class="fa fa-instagram" aria-hidden="true"></i></a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-4 col-md-4 col-sm-21 col-xs-12 col-lg-push-4 col-md-push-4 col-sm-push-0">
                    <div class="wd_about_infobox wd_toppadder20">
                        <div class="wd_about_infobox_img">
                            <span><img src="../js/home/images/content/line.png" alt="Line"
                                       class="img-responsive"></span>
                            <img src="../js/home/images/content/bride.png" alt="Groom" class="img-responsive">
                        </div>
                        <h2>Jenny Bellucci</h2>
                        <p>(D/o Mrs. Merry & Mr. Jhon Bellucci)</p>
                        <ul>
                            <li><a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a></li>
                            <li><a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a></li>
                            <li><a href="#"><i class="fa fa-instagram" aria-hidden="true"></i></a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 col-lg-pull-4 col-md-pull-4 col-sm-pull-0">
                    <div class="wd_about_infobox">
                        <h1>Invitation</h1>
                        <div class="wd_about_infobox_date">
                            <p>We inviting you and your family on</p>
                            <h3>Saturday</h3>
                            <h2>15 Oct 2015</h2>
                            <p>At St. Thomas's Church, London, U.K.</p>
                        </div>
                        <div class="wd_btn wd_single_index_menu">
                            <a href="#wd_contect_wrapper" class="smoothScroll">rsvp</a>
                        </div>
                    </div>
                </div>
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="wd_timer_wrapper">
                        <div class="wd_center_words">
                            <h4>不要忘记这个日子!</h4>
                        </div>
                        <div id="clockdiv">
                            <div><span class="days"></span>
                                <div class="smalltext">Days</div>
                            </div>
                            <div><span class="hours"></span>
                                <div class="smalltext">Hours</div>
                            </div>
                            <div><span class="minutes"></span>
                                <div class="smalltext">Minutes</div>
                            </div>
                            <div><span class="seconds"></span>
                                <div class="smalltext">Seconds</div>
                            </div>
                        </div>
                        <div class="wd_center_words">
                            <h4>我们的纪念日!</h4>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- About Wrapper End -->
<!-- Story Wrapper Start -->
<div section-scroll='2' class="wd_scroll_wrap">
    <div class="wd_story_wrapper wd_toppadder90 wd_bottompadder90">
        <div class="wd_overlay"></div>
        <div class="container">
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="wd_heading wow fadeInDown" data-wow-delay="0.3s">
                        <h4>Guoge & Kunkun</h4>
                        <h1>Our true love story</h1>
                        <img src="../js/home/images/content/heading.png" alt="Heading" class="img-responsive">
                    </div>
                </div>
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="wd_story_covers">
                        <div class="wd_story_line"></div>
                        <div class="wd_story_covers_box_left">
                            <div class="wd_story_dot"><span></span></div>
                            <div class="wd_story_covers_box_img">
                                <img src="../js/home/images/content/story_1.jpg" alt="Story">
                            </div>
                            <div class="wd_story_covers_box_datails">
                                <span>20 May 2010</span>
                                <h1>Our First Met</h1>
                                <span>That day changed Life</span>
                                <p>This is Photoshop's version of Lorem Ipsum. Proin gravida nibh vel velit auctor
                                    aliquet. Aenean sollicitudin, lorem quis bibendum auctor...</p>
                            </div>
                        </div>
                        <div class="wd_story_covers_box_right">
                            <div class="wd_story_dot"><span></span></div>
                            <div class="wd_story_covers_box_datails">
                                <span>20 May 2010</span>
                                <h1>Our First Dating</h1>
                                <span>Our Best Dinner Ever</span>
                                <p>This is Photoshop's version of Lorem Ipsum. Proin gravida nibh vel velit auctor
                                    aliquet. Aenean sollicitudin, lorem quis bibendum auctor...</p>
                            </div>
                            <div class="wd_story_covers_box_img">
                                <img src="../js/home/images/content/story_2.jpg" alt="Story">
                            </div>
                        </div>
                        <div class="wd_story_covers_box_left">
                            <div class="wd_story_dot"><span></span></div>
                            <div class="wd_story_covers_box_img">
                                <img src="../js/home/images/content/story_3.jpg" alt="Story">
                            </div>
                            <div class="wd_story_covers_box_datails">
                                <span>20 May 2010</span>
                                <h1>How he Proposed</h1>
                                <span>That was so wonderful</span>
                                <p>This is Photoshop's version of Lorem Ipsum. Proin gravida nibh vel velit auctor
                                    aliquet. Aenean sollicitudin, lorem quis bibendum auctor...</p>
                            </div>
                        </div>
                        <div class="wd_story_covers_box_right">
                            <div class="wd_story_dot"><span></span></div>
                            <div class="wd_story_covers_box_datails">
                                <span>20 May 2010</span>
                                <h1>Our First Kiss</h1>
                                <span>Feeling Awesome :)</span>
                                <p>This is Photoshop's version of Lorem Ipsum. Proin gravida nibh vel velit auctor
                                    aliquet. Aenean sollicitudin, lorem quis bibendum auctor...</p>
                            </div>
                            <div class="wd_story_covers_box_img">
                                <img src="../js/home/images/content/story_4.jpg" alt="Story">
                            </div>
                        </div>
                        <div class="wd_story_covers_box_left">
                            <div class="wd_story_dot"><span></span></div>
                            <div class="wd_story_covers_box_img">
                                <img src="../js/home/images/content/story_5.jpg" alt="Story">
                            </div>
                            <div class="wd_story_covers_box_datails">
                                <span>20 May 2010</span>
                                <h1>Now We Together</h1>
                                <span>We're waiting for the best</span>
                                <p>This is Photoshop's version of Lorem Ipsum. Proin gravida nibh vel velit auctor
                                    aliquet. Aenean sollicitudin, lorem quis bibendum auctor...</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Story Wrapper End -->
<!-- Event Wrapper Start -->
<div section-scroll='3' class="wd_scroll_wrap">
    <div class="wd_event_wrapper wd_toppadder90 wd_bottompadder50">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="wd_heading wow fadeInDown" data-wow-delay="0.3s">
                        <h4>Ceremony & party</h4>
                        <h1>THE WEDDING EVENT</h1>
                        <img src="../js/home/images/content/heading.png" alt="Heading" class="img-responsive">
                    </div>
                </div>
                <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                    <div class="wd_event_infobox">
                        <h2>Main Ceremony</h2>
                        <h1>7:30 pm</h1>
                        <span>St. Thomas's Church, London, U.K.</span>
                        <p>Proin gravida nibh vel velit auctor aliquet. Aenean sollicitudin, lorem quis bibendum auctor
                            vel velit auctor aliquet. Aenean sollicitudin, lorem quis <a href="#">Read More...</a></p>
                        <div class="clearfix"></div>
                        <a href="#"><img src="../js/home/images/content/map.png" alt="Map" class="img-responsive"></a>
                    </div>
                </div>
                <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 col-lg-push-4 col-md-push-4 col-sm-push-0">
                    <div class="wd_event_infobox">
                        <h2>Wedding Party</h2>
                        <h1>7:30 pm</h1>
                        <span>St. Thomas's Church, London, U.K.</span>
                        <p>Proin gravida nibh vel velit auctor aliquet. Aenean sollicitudin, lorem quis bibendum auctor
                            vel velit auctor aliquet. Aenean sollicitudin, lorem quis <a href="#">Read More...</a></p>
                        <div class="clearfix"></div>
                        <a href="#"><img src="../js/home/images/content/map.png" alt="Map" class="img-responsive"></a>
                    </div>
                </div>
                <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 col-lg-pull-4 col-md-pull-4 col-sm-pull-0">
                    <div class="wd_event_infobox">
                        <img src="../js/home/images/content/event_img.gif" alt="Event Image">
                        <div class="wd_btn wd_single_index_menu">
                            <a href="#wd_contect_wrapper" class="smoothScroll">rsvp</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Event Wrapper End -->
<!-- Guest Wrapper Start -->
<div section-scroll='4' class="wd_scroll_wrap" id="wd_contect_wrapper">
    <div class="wd_guest_wrapper wd_toppadder90">
        <div class="wd_overlay"></div>
        <div class="container">
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="wd_heading wow fadeInDown" data-wow-delay="0.3s">
                        <h4>登录</h4>
                        <h1>账号登录使用功能!</h1>
                        <img src="../js/home/images/content/heading.png" alt="Heading" class="img-responsive">
                    </div>
                </div>
                <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
                    <div class="wd_guest_infobox">
                        <h2>欢迎使用爱情系统</h2>
                        <h4>请在使用前阅读一下文本</h4>
                        <p>本系统是给我最亲爱的国歌制作，以及使用，如果你在无意之间看到此网站，也可以使用此网站的功能，
                            谢绝盗用网站的资源，本网站归<span style="background-color:#0052A3">《昆仔科技快讯》</span>所有，违者必究。谢谢</p>
                        <h2>用户 注册</h2>
                        <p>如果你不是我亲爱的国歌的话，也是可以注册的，现在这个版本的是在开发中的，我会不断完善这个项目，给亲爱的国歌更好的体验，给用户
                            更好的体验，功能继续完善中......</p>
                    </div>
                    <div class="wd_guest_slider">
                        <div class="owl-carousel owl-theme">
                            <div class="item"><img src="../js/home/images/content/gue1.png" alt="Slider"
                                                   class="img-responsive">
                            </div>
                            <div class="item"><img src="../js/home/images/content/gue2.png" alt="Slider"
                                                   class="img-responsive">
                            </div>
                            <div class="item"><img src="../js/home/images/content/gue3.png" alt="Slider"
                                                   class="img-responsive">
                            </div>
                            <div class="item"><img src="../js/home/images/content/gue1.png" alt="Slider"
                                                   class="img-responsive">
                            </div>
                            <div class="item"><img src="../js/home/images/content/gue2.png" alt="Slider"
                                                   class="img-responsive">
                            </div>
                            <div class="item"><img src="../js/home/images/content/gue3.png" alt="Slider"
                                                   class="img-responsive">
                            </div>
                            <div class="item"><img src="../js/home/images/content/gue1.png" alt="Slider"
                                                   class="img-responsive">
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
                    <div class="wd_guest_formbox">
                        <span>注册或登录?</span>
                        <h4>赶快来吧!</h4>


                        <form action=<%=contextPath%>"/userLoginAction!userLogin.action" id="form1" method="post">
                            <div class="wd_guest_form">
                                <div class="row">
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                        <label>账号 :</label>
                                        <input type="text" name="userModel.uname">
                                    </div>
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                        <label>密码 :</label>
                                        <input type="text" name="userModel.password">
                                    </div>
                                    <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                        <label>推荐码 :</label>
                                        <input type="text" name="userModel.verifykey">
                                    </div>
                                    <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                        <label>级别 :</label>
                                        <select name="userModel.level">
                                            <option value="0">爱人</option>
                                            <option value="1">朋友</option>
                                            <option value="2">游客</option>
                                        </select>
                                    </div>
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                        <div class="wd_btn">
                                            <input type="button" name="login" id="loginbutton" value="登录"/>
                                            <%--<a href="#">登录</a>--%>
                                        </div>
                                    </div>
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                        <div class="wd_btn">
                                            <%--<a href="#">注册</a>--%>
                                            <input type="button" name="register" id="registerbutton" value="注册"/>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </form>


                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Testimonial Wrapper End -->
    <div class="wd_testimonial_wrapper wd_toppadder70 wd_bottompadder70">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="wd_testimonial_slider">
                        <div class="owl-carousel owl-theme">
                            <div class="item">
                                <div class="wd_testimo_box">
                                    <img src="../js/home/images/content/heart.png" alt="Testimonial">
                                    <p>“ Better to have loved and lost, than to have never loved ”</p>
                                    <h4>~ China Kun ~</h4>
                                </div>
                            </div>
                            <div class="item">
                                <div class="wd_testimo_box">
                                    <img src="../js/home/images/content/heart.png" alt="Testimonial">
                                    <p>“ I look at you and see the rest of my life in front of my eyes. ”</p>
                                    <h4>~ China Guo ~</h4>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Testimonial Wrapper End -->
<!-- Family Wrapper Start -->
<div section-scroll='5' class="wd_scroll_wrap">
    <div class="wd_family_wrapper wd_toppadder90 wd_bottompadder90">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="wd_heading wow fadeInDown" data-wow-delay="0.3s">
                        <h4>我重要的人</h4>
                        <h1>可爱的家庭</h1>
                        <img src="../js/home/images/content/heading.png" alt="Heading" class="img-responsive">
                    </div>
                </div>
                <div class="wd_family_tabbox">
                    <!-- Nav tabs -->
                    <ul class="nav nav-tabs" role="tablist">
                        <li role="presentation" class="active"><a href="#groom" aria-controls="groom" role="tab"
                                                                  data-toggle="tab"><img
                                src="../js/home/images/content/tab1.jpg"
                                alt="Groom">
                            <p>Mark</p></a></li>
                        <li role="presentation"><a href="#bride" aria-controls="bride" role="tab" data-toggle="tab"><img
                                src="../js/home/images/content/tab2.jpg" alt="Bride">
                            <p>Jenny</p></a></li>
                    </ul>
                    <!-- Tab panes -->
                    <div class="tab-content">
                        <div role="tabpanel" class="tab-pane fade in active" id="groom">
                            <div class="wd_family_slider">
                                <div class="owl-carousel owl-theme">
                                    <div class="item">
                                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                            <div class="wd_family_infobox">
                                                <div class="wd_family_infobox_img">
                                                    <span><img src="../js/home/images/content/line2.png"
                                                               alt="Line"></span>
                                                    <img src="../js/home/images/content/fm1.jpg" alt="Family">
                                                </div>
                                                <h2>Mr. Clark Wills</h2>
                                                <p>(Mark’s Father)</p>
                                                <ul>
                                                    <li><a href="#"><i class="fa fa-facebook"
                                                                       aria-hidden="true"></i></a></li>
                                                    <li><a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a>
                                                    </li>
                                                    <li><a href="#"><i class="fa fa-instagram"
                                                                       aria-hidden="true"></i></a></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="item">
                                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                            <div class="wd_family_infobox">
                                                <div class="wd_family_infobox_img">
                                                    <span><img src="../js/home/images/content/line2.png"
                                                               alt="Line"></span>
                                                    <img src="../js/home/images/content/fm2.jpg" alt="Family">
                                                </div>
                                                <h2>Jeniffer Wills</h2>
                                                <p>(Mark’s Mother)</p>
                                                <ul>
                                                    <li><a href="#"><i class="fa fa-facebook"
                                                                       aria-hidden="true"></i></a></li>
                                                    <li><a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a>
                                                    </li>
                                                    <li><a href="#"><i class="fa fa-instagram"
                                                                       aria-hidden="true"></i></a></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="item">
                                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                            <div class="wd_family_infobox">
                                                <div class="wd_family_infobox_img">
                                                    <span><img src="../js/home/images/content/line2.png"
                                                               alt="Line"></span>
                                                    <img src="../js/home/images/content/fm3.jpg" alt="Family">
                                                </div>
                                                <h2>Carolyn</h2>
                                                <p>(Mark’s Sister)</p>
                                                <ul>
                                                    <li><a href="#"><i class="fa fa-facebook"
                                                                       aria-hidden="true"></i></a></li>
                                                    <li><a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a>
                                                    </li>
                                                    <li><a href="#"><i class="fa fa-instagram"
                                                                       aria-hidden="true"></i></a></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="item">
                                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                            <div class="wd_family_infobox">
                                                <div class="wd_family_infobox_img">
                                                    <span><img src="../js/home/images/content/line2.png"
                                                               alt="Line"></span>
                                                    <img src="../js/home/images/content/fm4.jpg" alt="Family">
                                                </div>
                                                <h2>Donald</h2>
                                                <p>(Mark’s Brother)</p>
                                                <ul>
                                                    <li><a href="#"><i class="fa fa-facebook"
                                                                       aria-hidden="true"></i></a></li>
                                                    <li><a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a>
                                                    </li>
                                                    <li><a href="#"><i class="fa fa-instagram"
                                                                       aria-hidden="true"></i></a></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="item">
                                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                            <div class="wd_family_infobox">
                                                <div class="wd_family_infobox_img">
                                                    <span><img src="../js/home/images/content/line2.png"
                                                               alt="Line"></span>
                                                    <img src="../js/home/images/content/fm1.jpg" alt="Family">
                                                </div>
                                                <h2>Mr. Clark Wills</h2>
                                                <p>(Mark’s Father)</p>
                                                <ul>
                                                    <li><a href="#"><i class="fa fa-facebook"
                                                                       aria-hidden="true"></i></a></li>
                                                    <li><a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a>
                                                    </li>
                                                    <li><a href="#"><i class="fa fa-instagram"
                                                                       aria-hidden="true"></i></a></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div role="tabpanel" class="tab-pane fade" id="bride">
                            <div class="wd_family_slider">
                                <div class="owl-carousel owl-theme">
                                    <div class="item">
                                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                            <div class="wd_family_infobox">
                                                <div class="wd_family_infobox_img">
                                                    <span><img src="../js/home/images/content/line2.png"
                                                               alt="Line"></span>
                                                    <img src="../js/home/images/content/fm5.jpg" alt="Family">
                                                </div>
                                                <h2>Mr. Clark Wills</h2>
                                                <p>(Jenny’s Father)</p>
                                                <ul>
                                                    <li><a href="#"><i class="fa fa-facebook"
                                                                       aria-hidden="true"></i></a></li>
                                                    <li><a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a>
                                                    </li>
                                                    <li><a href="#"><i class="fa fa-instagram"
                                                                       aria-hidden="true"></i></a></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="item">
                                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                            <div class="wd_family_infobox">
                                                <div class="wd_family_infobox_img">
                                                    <span><img src="../js/home/images/content/line2.png"
                                                               alt="Line"></span>
                                                    <img src="../js/home/images/content/fm6.jpg" alt="Family">
                                                </div>
                                                <h2>Jeniffer Wills</h2>
                                                <p>(Jenny’s Mother)</p>
                                                <ul>
                                                    <li><a href="#"><i class="fa fa-facebook"
                                                                       aria-hidden="true"></i></a></li>
                                                    <li><a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a>
                                                    </li>
                                                    <li><a href="#"><i class="fa fa-instagram"
                                                                       aria-hidden="true"></i></a></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="item">
                                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                            <div class="wd_family_infobox">
                                                <div class="wd_family_infobox_img">
                                                    <span><img src="../js/home/images/content/line2.png"
                                                               alt="Line"></span>
                                                    <img src="../js/home/images/content/fm7.jpg" alt="Family">
                                                </div>
                                                <h2>Carolyn</h2>
                                                <p>(Jenny’s Sister)</p>
                                                <ul>
                                                    <li><a href="#"><i class="fa fa-facebook"
                                                                       aria-hidden="true"></i></a></li>
                                                    <li><a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a>
                                                    </li>
                                                    <li><a href="#"><i class="fa fa-instagram"
                                                                       aria-hidden="true"></i></a></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="item">
                                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                            <div class="wd_family_infobox">
                                                <div class="wd_family_infobox_img">
                                                    <span><img src="../js/home/images/content/line2.png"
                                                               alt="Line"></span>
                                                    <img src="../js/home/images/content/fm8.jpg" alt="Family">
                                                </div>
                                                <h2>Donald</h2>
                                                <p>(Jenny’s Brother)</p>
                                                <ul>
                                                    <li><a href="#"><i class="fa fa-facebook"
                                                                       aria-hidden="true"></i></a></li>
                                                    <li><a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a>
                                                    </li>
                                                    <li><a href="#"><i class="fa fa-instagram"
                                                                       aria-hidden="true"></i></a></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="item">
                                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                            <div class="wd_family_infobox">
                                                <div class="wd_family_infobox_img">
                                                    <span><img src="../js/home/images/content/line2.png"
                                                               alt="Line"></span>
                                                    <img src="../js/home/images/content/fm5.jpg" alt="Family">
                                                </div>
                                                <h2>Mr. Clark Wills</h2>
                                                <p>(Jenny’s Father)</p>
                                                <ul>
                                                    <li><a href="#"><i class="fa fa-facebook"
                                                                       aria-hidden="true"></i></a></li>
                                                    <li><a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a>
                                                    </li>
                                                    <li><a href="#"><i class="fa fa-instagram"
                                                                       aria-hidden="true"></i></a></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Family Wrapper End -->
<!-- Gallery Wrapper Start -->
<div section-scroll='6' class="wd_scroll_wrap">
    <div class="wd_gallery_wrapper wd_toppadder90 wd_bottompadder90">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="wd_heading wow fadeInDown" data-wow-delay="0.3s">
                        <h4>Jenny & Mark</h4>
                        <h1>memorable photo gallery</h1>
                        <img src="../js/home/images/content/heading.png" alt="Heading" class="img-responsive">
                    </div>
                </div>
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="wd_gallery_slider popup-gallery">
                        <div class="owl-carousel owl-theme">
                            <div class="item">
                                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                    <div class="wd_gallery_slide">
                                        <img src="../js/home/images/content/image_1.jpg" alt="Wedding">
                                        <div class="ast_glr_overlay">
                                            <p>Making A Love</p>
                                            <a href="../js/home/images/content/image_1_zoom.jpg" title=""><i
                                                    class="fa fa-expand"
                                                    aria-hidden="true"></i></a>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                    <div class="wd_gallery_slide">
                                        <img src="../js/home/images/content/image_small_1.jpg" alt="Wedding">
                                        <div class="ast_glr_overlay">
                                            <p>Making A Love</p>
                                            <a href="../js/home/images/content/image_small_1_zoom.jpg" title=""><i
                                                    class="fa fa-expand" aria-hidden="true"></i></a>
                                        </div>
                                    </div>
                                    <div class="wd_gallery_slide">
                                        <img src="../js/home/images/content/image_small_2.jpg" alt="Wedding">
                                        <div class="ast_glr_overlay">
                                            <p>Making A Love</p>
                                            <a href="../js/home/images/content/image_small_2_zoom.jpg" title=""><i
                                                    class="fa fa-expand" aria-hidden="true"></i></a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="item">
                                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                    <div class="wd_gallery_slide">
                                        <img src="../js/home/images/content/image_2.jpg" alt="Wedding">
                                        <div class="ast_glr_overlay">
                                            <p>Making A Love</p>
                                            <a href="../js/home/images/content/image_2_zoom.jpg" title=""><i
                                                    class="fa fa-expand"
                                                    aria-hidden="true"></i></a>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                    <div class="wd_gallery_slide">
                                        <img src="../js/home/images/content/image_small_3.jpg" alt="Wedding">
                                        <div class="ast_glr_overlay">
                                            <p>Making A Love</p>
                                            <a href="../js/home/images/content/image_small_3_zoom.jpg" title=""><i
                                                    class="fa fa-expand" aria-hidden="true"></i></a>
                                        </div>
                                    </div>
                                    <div class="wd_gallery_slide">
                                        <img src="../js/home/images/content/image_small_4.jpg" alt="Wedding">
                                        <div class="ast_glr_overlay">
                                            <p>Making A Love</p>
                                            <a href="../js/home/images/content/image_small_4_zoom.jpg" title=""><i
                                                    class="fa fa-expand" aria-hidden="true"></i></a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="item">
                                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                    <div class="wd_gallery_slide">
                                        <img src="../js/home/images/content/image_3.jpg" alt="Wedding">
                                        <div class="ast_glr_overlay">
                                            <p>Making A Love</p>
                                            <a href="../js/home/images/content/image_3_zoom.jpg" title=""><i
                                                    class="fa fa-expand"
                                                    aria-hidden="true"></i></a>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                    <div class="wd_gallery_slide">
                                        <img src="../js/home/images/content/image_small_5.jpg" alt="Wedding">
                                        <div class="ast_glr_overlay">
                                            <p>Making A Love</p>
                                            <a href="../js/home/images/content/image_small_5_zoom.jpg" title=""><i
                                                    class="fa fa-expand" aria-hidden="true"></i></a>
                                        </div>
                                    </div>
                                    <div class="wd_gallery_slide">
                                        <img src="../js/home/images/content/image_small_6.jpg" alt="Wedding">
                                        <div class="ast_glr_overlay">
                                            <p>Making A Love</p>
                                            <a href="../js/home/images/content/image_small_6_zoom.jpg" title=""><i
                                                    class="fa fa-expand" aria-hidden="true"></i></a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="item">
                                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                    <div class="wd_gallery_slide">
                                        <img src="../js/home/images/content/image_1.jpg" alt="Wedding">
                                        <div class="ast_glr_overlay">
                                            <p>Making A Love</p>
                                            <a href="../js/home/images/content/image_1_zoom.jpg" title=""><i
                                                    class="fa fa-expand"
                                                    aria-hidden="true"></i></a>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                    <div class="wd_gallery_slide">
                                        <img src="../js/home/images/content/image_small_1.jpg" alt="Wedding">
                                        <div class="ast_glr_overlay">
                                            <p>Making A Love</p>
                                            <a href="../js/home/images/content/image_small_1_zoom.jpg" title=""><i
                                                    class="fa fa-expand" aria-hidden="true"></i></a>
                                        </div>
                                    </div>
                                    <div class="wd_gallery_slide">
                                        <img src="../js/home/images/content/image_small_2.jpg" alt="Wedding">
                                        <div class="ast_glr_overlay">
                                            <p>Making A Love</p>
                                            <a href="../js/home/images/content/image_small_2_zoom.jpg" title=""><i
                                                    class="fa fa-expand" aria-hidden="true"></i></a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="item">
                                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                    <div class="wd_gallery_slide">
                                        <img src="../js/home/images/content/image_2.jpg" alt="Wedding">
                                        <div class="ast_glr_overlay">
                                            <p>Making A Love</p>
                                            <a href="../js/home/images/content/image_2_zoom.jpg" title=""><i
                                                    class="fa fa-expand"
                                                    aria-hidden="true"></i></a>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                    <div class="wd_gallery_slide">
                                        <img src="../js/home/images/content/image_small_3.jpg" alt="Wedding">
                                        <div class="ast_glr_overlay">
                                            <p>Making A Love</p>
                                            <a href="../js/home/images/content/image_small_3_zoom.jpg" title=""><i
                                                    class="fa fa-expand" aria-hidden="true"></i></a>
                                        </div>
                                    </div>
                                    <div class="wd_gallery_slide">
                                        <img src="../js/home/images/content/image_small_4.jpg" alt="Wedding">
                                        <div class="ast_glr_overlay">
                                            <p>Making A Love</p>
                                            <a href="../js/home/images/content/image_small_4_zoom.jpg" title=""><i
                                                    class="fa fa-expand" aria-hidden="true"></i></a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Gallery Wrapper End -->
<!-- Blog Wrapper Start -->
<div section-scroll='7' class="wd_scroll_wrap">
    <div class="wd_blog_wrapper wd_toppadder90 wd_bottompadder40">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="wd_heading wow fadeInDown" data-wow-delay="0.3s">
                        <h4>我们的生活</h4>
                        <h1>来自我们记录点滴</h1>
                        <img src="../js/home/images/content/heading.png" alt="Heading" class="img-responsive">
                    </div>
                </div>
                <div class="wd_blog_box">
                    <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                        <div class="wd_blog_img">
                            <img src="../js/home/images/content/blog1.jpg" alt="Blog">
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                        <div class="wd_blog_info">
                            <h3>Planning Honeymoon Trip</h3>
                            <ul>
                                <li><a href="#"><i class="fa fa-calendar-o" aria-hidden="true"></i> 20 May 2017</a></li>
                                <li><a href="#"><i class="fa fa-eye" aria-hidden="true"></i> 240 View</a></li>
                                <li><a href="#"><i class="fa fa-heart" aria-hidden="true"></i> 143 Likes</a></li>
                            </ul>
                            <p>This is Photoshop's version of Lorem Ipsum. Proin gravida nibh vel velit auctor aliquet.
                                Aenean sollicitudin, lorem quis bibendum auctor, nisi elit consequat ipsum, nec sagittis
                                sem nibh id elit..</p>
                            <div class="wd_btn">
                                <a href="#">read more</a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="wd_blog_box">
                    <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 col-lg-push-6 col-md-push-6 col-sm-push-6">
                        <div class="wd_blog_img">
                            <img src="../js/home/images/content/blog2.jpg" alt="Blog">
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 col-lg-pull-6 col-md-pull-6 col-sm-pull-6">
                        <div class="wd_blog_info">
                            <h3>Surprises For Guests</h3>
                            <ul>
                                <li><a href="#"><i class="fa fa-calendar-o" aria-hidden="true"></i> 20 May 2017</a></li>
                                <li><a href="#"><i class="fa fa-eye" aria-hidden="true"></i> 240 View</a></li>
                                <li><a href="#"><i class="fa fa-heart" aria-hidden="true"></i> 143 Likes</a></li>
                            </ul>
                            <p>This is Photoshop's version of Lorem Ipsum. Proin gravida nibh vel velit auctor aliquet.
                                Aenean sollicitudin, lorem quis bibendum auctor, nisi elit consequat ipsum, nec sagittis
                                sem nibh id elit..</p>
                            <div class="wd_btn">
                                <a href="#">read more</a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="wd_blog_box">
                    <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                        <div class="wd_blog_img">
                            <img src="../js/home/images/content/blog3.jpg" alt="Blog">
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                        <div class="wd_blog_info">
                            <h3>Bachelor Party!</h3>
                            <ul>
                                <li><a href="#"><i class="fa fa-calendar-o" aria-hidden="true"></i> 20 May 2017</a></li>
                                <li><a href="#"><i class="fa fa-eye" aria-hidden="true"></i> 240 View</a></li>
                                <li><a href="#"><i class="fa fa-heart" aria-hidden="true"></i> 143 Likes</a></li>
                            </ul>
                            <p>This is Photoshop's version of Lorem Ipsum. Proin gravida nibh vel velit auctor aliquet.
                                Aenean sollicitudin, lorem quis bibendum auctor, nisi elit consequat ipsum, nec sagittis
                                sem nibh id elit..</p>
                            <div class="wd_btn">
                                <a href="#">read more</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Blo Wrapper End -->
<!-- Contact Wrapper Start -->
<div section-scroll='8' class="wd_scroll_wrap">
    <div class="wd_contact_wrapper wd_toppadder90 wd_bottompadder90">
        <div class="wd_overlay"></div>
        <div class="container">
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="wd_heading wow fadeInDown" data-wow-delay="0.3s">
                        <h4>假如你有任何疑问</h4>
                        <h1>请联系我们</h1>
                        <img src="../js/home/images/content/heading.png" alt="Heading" class="img-responsive">
                    </div>
                </div>
                <div class="col-lg-8 col-md-10 col-sm-12 col-xs-12 col-lg-offset-2 col-md-offset-1 col-sm-offset-0 col-xs-offset-0">
                    <div class="wd_contact_form">
                        <div class="row">
                            <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                <input type="text" placeholder="Full Name">
                                <input type="text" placeholder="Email">
                                <input type="text" placeholder="Phone">
                            </div>
                            <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                <textarea rows="7" placeholder="Message"></textarea>
                            </div>
                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                <div class="wd_btn">
                                    <button type="submit" id="wd_submit">Send a Message</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Contact Wrapper End -->
    <!-- Footer Wrapper Start -->
    <div class="wd_footer_wrapper wd_toppadder90 wd_bottompadder100">
        <div class="container">
            <div class="row">
                <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
                    <div class="wd_footer_infobox">
                        <div class="wd_footicon">
                            <i class="fa fa-map-marker" aria-hidden="true"></i>
                        </div>
                        <h2>家</h2>
                        <p>中国</p>
                    </div>
                </div>
                <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
                    <div class="wd_footer_infobox">
                        <div class="wd_footicon">
                            <i class="fa fa-phone" aria-hidden="true"></i>
                        </div>
                        <h2>联系方式</h2>
                        <p>QQ:656678879 <br>微信:kunzaikj521</p>
                    </div>
                </div>
                <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
                    <div class="wd_footer_infobox">
                        <div class="wd_footicon">
                            <i class="fa fa-envelope" aria-hidden="true"></i>
                        </div>
                        <h2>邮箱</h2>
                        <p>kunzaikx@qq.com <br>kunzaikj@qq.com</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="wd_footer_bottom_wrapper wd_toppadder50 wd_bottompadder50">
        <a href="javascript:void(0);" id="scroll" title="Scroll to Top" style="display: none;"><i
                class="fa fa-long-arrow-up" aria-hidden="true"></i></a>
        <div class="col-md-12">
            <div class="wd_footer_section">
                <img src="../js/home/images/header/flogo.png" alt="Logo" class="img-responsive">
                <p>Copyright &copy; 2017.昆仔科技快讯.<a target="_blank" href="#"></a>
                </p>
            </div>
        </div>
    </div>
</div>


<!-- Footer Wrapper End -->
<!--main js file start-->
<script type="text/javascript" src="../js/home/js/jquery.js"></script>
<script type="text/javascript" src="../js/home/js/bootstrap.js"></script>
<script type="text/javascript" src="../js/home/js/smoothscroll.js"></script>
<script type="text/javascript" src="../js/home/js/owl.carousel.js"></script>
<script type="text/javascript" src="../js/home/js/modernizr.js"></script>
<script type="text/javascript" src="../js/home/js/jquery.magnific-popup.js"></script>
<script type="text/javascript" src="../js/home/js/wow.js"></script>
<script type="text/javascript" src="../js/home/js/custom.js"></script>
<script type="text/javascript">
    $(window).on("load", function () {
        var wow = new WOW({
            boxClass: 'wow',
            animateClass: 'animated',
            offset: 0,
            mobile: true,
            mobile: true,
            live: true
        });
        wow.init();
    });


    /*用户登录或注册的js*/
    $(document).ready(function () {
        $("#loginbutton").click(function () {
            document.getElementById("form1").action = "../userLoginAction!userLogin.action";
            $("#form1").submit();
        });
        $("#registerbutton").click(function () {
            document.getElementById("form1").action = "../userLoginAction!testSuccess.action";
            $("#form1").submit();
        });


    });


</script>
<!--main js file end-->
</body>
</html>