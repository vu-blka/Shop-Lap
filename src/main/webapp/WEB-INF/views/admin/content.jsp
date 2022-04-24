<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dashboard</title>
    </head>
    <body>

        <div class="inner-block">
            <!--market updates updates-->
            <div class="market-updates">
                <div class="col-md-4 market-update-gd">
                    <div class="market-update-block clr-block-1">
                        <div class="col-md-8 market-update-left">
                            <h3>${sizeUser }</h3>
                            <h4>Registered User</h4>
                           
                        </div>
                        <div class="col-md-4 market-update-right">
                            <i class="fa fa-file-text-o"> </i>
                        </div>
                        <div class="clearfix"> </div>
                    </div>
                </div>
                <div class="col-md-4 market-update-gd">
                    <div class="market-update-block clr-block-2">
                        <div class="col-md-8 market-update-left">
                            <h3>${size }</h3>
                            <h4>New Order</h4>
                            
                        </div>
                        <div class="col-md-4 market-update-right">
                            <i class="fa fa-eye"> </i>
                        </div>
                        <div class="clearfix"> </div>
                    </div>
                </div>
                <div class="col-md-4 market-update-gd">
                    <div class="market-update-block clr-block-3">
                        <div class="col-md-8 market-update-left">
                            <h3>${sizeMessage }</h3>
                            <h4>New Messages</h4>
                           
                        </div>
                        <div class="col-md-4 market-update-right">
                            <i class="fa fa-envelope-o"> </i>
                        </div>
                        <div class="clearfix"> </div>
                    </div>
                </div>
                <div class="clearfix"> </div>
            </div>
            <!--market updates end here-->
            <!--mainpage chit-chating-->
            <div class="chit-chat-layer1">
                <div class="col-md-6 chit-chat-layer1-left">
                    <div class="work-progres">
                        <div class="chit-chat-heading">
                            Recent Followers
                        </div>
                        <div class="table-responsive">
                            <table class="table table-hover">
                                <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>Project</th>
                                        <th>Products</th>                                   

                                        <th>Sold</th>
                                        <th>Status</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="item" items="${listBrands }">
									<tr>
										<td>${item.id }</td>
										<td>${item.brand }</td>
										<td>${item.countProduct }</td>
										<td><span class="badge badge-info">${item.sold }</span></td>
										<c:if test="${item.sold>=1000 }">
											<td><span class="label label-primary"> Top  </span></td>
										</c:if>
										<c:if test="${item.sold>=500 && item.sold<1000 }">
											<td><span class="label label-info">Basic</span></td>
										</c:if>
										<c:if test="${item.sold<500 }">
											<td><span class="label label-danger">Bot</span></td>
										</c:if>
									</tr>
								</c:forEach>
                                
                                 
                                
                               
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="col-md-6 chit-chat-layer1-rit">    	
                    <div class="geo-chart">
                        <section id="charts1" class="charts">
                            <div class="wrapper-flex">

                                <table id="myTable" class="geoChart tableChart data-table col-table" style="display:none;">
                                    <caption>Student Nationalities Table</caption>
                                    <tr>
                                        <th scope="col" data-type="string">Country</th>
                                        <th scope="col" data-type="number">Number of Students</th>
                                        <th scope="col" data-role="annotation">Annotation</th>
                                    </tr>
                                    <tr>
                                        <td>China</td>
                                        <td align="right">20</td>
                                        <td align="right">20</td>
                                    </tr>
                                    <tr>
                                        <td>Colombia</td>
                                        <td align="right">5</td>
                                        <td align="right">5</td>
                                    </tr>
                                    <tr>
                                        <td>France</td>
                                        <td align="right">3</td>
                                        <td align="right">3</td>
                                    </tr>
                                    <tr>
                                        <td>Italy</td>
                                        <td align="right">1</td>
                                        <td align="right">1</td>
                                    </tr>
                                    <tr>
                                        <td>Japan</td>
                                        <td align="right">18</td>
                                        <td align="right">18</td>
                                    </tr>
                                    <tr>
                                        <td>Kazakhstan</td>
                                        <td align="right">1</td>
                                        <td align="right">1</td>
                                    </tr>
                                    <tr>
                                        <td>Mexico</td>
                                        <td align="right">1</td>
                                        <td align="right">1</td>
                                    </tr>
                                    <tr>
                                        <td>Poland</td>
                                        <td align="right">1</td>
                                        <td align="right">1</td>
                                    </tr>
                                    <tr>
                                        <td>Russia</td>
                                        <td align="right">11</td>
                                        <td align="right">11</td>
                                    </tr>
                                    <tr>
                                        <td>Spain</td>
                                        <td align="right">2</td>
                                        <td align="right">2</td>
                                    </tr>
                                    <tr>
                                        <td>Tanzania</td>
                                        <td align="right">1</td>
                                        <td align="right">1</td>
                                    </tr>
                                    <tr>
                                        <td>Turkey</td>
                                        <td align="right">2</td>
                                        <td align="right">2</td>
                                    </tr>

                                </table>

                                <div class="col geo_main">
                                    <h3 id="geoChartTitle">World Market</h3>
                                    <div id="geoChart" class="chart"> </div>
                                </div>


                            </div><!-- .wrapper-flex -->
                        </section>				
                    </div>
                </div>
                <div class="clearfix"> </div>
            </div>
            <!--main page chit chating end here-->
            <!--main page chart start here-->
            <div class="main-page-charts">
                <div class="main-page-chart-layer1">
                    <div class="col-md-6 chart-layer1-left"> 
                        <div class="glocy-chart">
                            <div class="span-2c">  
                                <h3 class="tlt">Sales Analytics</h3>
                                <canvas id="bar" height="300" width="400" style="width: 400px; height: 300px;"></canvas>
                                <script>
                                    var barChartData = {
                                        labels: ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "jul"],
                                        datasets: [
                                            {
                                                fillColor: "#FC8213",
                                                data: [65, 59, 90, 81, 56, 55, 40]
                                            },
                                            {
                                                fillColor: "#337AB7",
                                                data: [28, 48, 40, 19, 96, 27, 100]
                                            }
                                        ]

                                    };
                                    new Chart(document.getElementById("bar").getContext("2d")).Bar(barChartData);

                                </script>
                            </div> 			  		   			
                        </div>
                    </div>
                    <div class="col-md-6 chart-layer1-right"> 
                        <div class="user-marorm">
                            <div class="malorum-top">				
                            </div>
                            <div class="malorm-bottom">
                                <span class="malorum-pro"> </span>
                                <h4>unde omnis iste</h4>
                                <h2>Melorum</h2>
                                <p>But I must explain to you how all this mistaken idea of denouncing pleasure and praising.</p>
                                <ul class="malorum-icons">
                                    <li><a href="#"><i class="fa fa-facebook"> </i>
                                            <div class="tooltip"><span>Facebook</span></div>
                                        </a></li>
                                    <li><a href="#"><i class="fa fa-twitter"> </i>
                                            <div class="tooltip"><span>Twitter</span></div>
                                        </a></li>
                                    <li><a href="#"><i class="fa fa-google-plus"> </i>
                                            <div class="tooltip"><span>Google</span></div>
                                        </a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="clearfix"> </div>
                </div>
            </div>

        </div>

    </body>
</html>
