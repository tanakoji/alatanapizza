<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="Content-Style-Type" content="text/css" />
	<link rel="stylesheet" href="./css/alatanapizza.css">
	<link rel="stylesheet" href="./css/product.css">

<title>商品詳細画面</title>
<style type="text/css">
#total1{
			font-size:25px;
			width:50%;
			background:rgba(0,0,0,0.5);
			padding:2.5%;
			margin-left:25%;
		}
		#product_count{
			-moz-appearance: none;
			-webkit-appearance: none;
			appearance: none;
			background-color: rgb(255, 152, 0, 0.1);
			border: 1px solid #dddddd;
			border-radius: 10px;
			padding: 5px 20px;
			color: black;
			font-weight:bold;
		}
		#total_price{
			text-align:right;
			border-radius: 10px;
			width: 10%;
			padding:8px 0.1px;
			font-size:20px;
			font-weight:bold;
		}

</style>



<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script>
        $(function() {
            $('input[name="product"]:radio').change(function() {
                var product_val = $('input[name="product"]:checked').val();
                if(product_val == window.undefined){
                    product_val = $('#sAndDPrice').attr("value") || "0";
                }
                var count = $('#topping input:checkbox:checked').length;
                var topping_price = parseInt(count) * 324;
                var product_menu_count = $('[name="productCount"]').val();
                var total_price = (parseInt(product_val) + parseInt(topping_price)) * parseInt(product_menu_count);
                $('input[name="total_price"]').val(total_price);
                $('#total_price_text').text(total_price);
            });

            $('.topping_menu').change(function() {
                var product_val = $('input[name="product"]:checked').val();
                if(product_val == window.undefined){
                    product_val = $('#sAndDPrice').attr("value") || "0";
                }
                var count = $('#topping input:checkbox:checked').length;
                var topping_price = parseInt(count) * 324;
                var product_menu_count = $('[name="productCount"]').val();
                var total_price = (parseInt(product_val) + parseInt(topping_price)) * parseInt(product_menu_count);
                $('input[name="total_price"]').val(total_price);
                $('#total_price_text').text(total_price);
            });

            $('#product_count').change(function() {
                var product_val = $('input[name="product"]:checked').val();
                if(product_val == window.undefined){
                    product_val = $('#sAndDPrice').attr("value") || "0";
                }
                var count = $('#topping input:checkbox:checked').length;
                var topping_price = parseInt(count) * 324;
                var product_menu_count = $('[name="productCount"]').val();
                var total_price = (parseInt(product_val) + parseInt(topping_price)) * parseInt(product_menu_count);
                $('input[name="total_price"]').val(total_price);
                $('#total_price_text').text(total_price);
            });
            $(function() {
                var product_val = $('input[name="product"]:checked').val();
                if(product_val == window.undefined){
                    product_val = $('#sAndDPrice').attr("value") || "0";
                }
                var count = $('#topping input:checkbox:checked').length;
                var topping_price = parseInt(count) * 324;
                var product_menu_count = $('[name="productCount"]').val();
                var total_price = (parseInt(product_val) + parseInt(topping_price)) * parseInt(product_menu_count);
                $('input[name="total_price"]').val(total_price);
                $('#total_price_text').text(total_price);
            });

            $('#sAndDPrice').change(function() {
            	var sAndDPrice = sAndDPrice_val();
            	var product_menu_count = $('[name="productCount"]').val();
            	var total_price = parseInt(sAndDPrice_val) * parseInt(product_menu_count);
          	  $('input:text[name="total_price"]').val(sAndDPrice);
        	});

        });
    </script>

</head>
<body>
	<!-- ヘッダー -->
	<jsp:include page="include_header.jsp" />

	<s:form action="CartProductAction" name="select">

	<table class="detailsTable">
			<tr>
			<th>
			<span id="category">
			<!-- カテゴリーの表示 -->
			<s:if test="session.d_category_id==2">
			<h2>Pizza</h2>
			</s:if>
			<s:if test="session.d_category_id==3">
			<h2>SideMenu</h2>
			</s:if>
			<s:if test="session.d_category_id==4">
			<h2>DrinkMenu</h2>
			</s:if>
			</span>
			</th>
			</tr>

			<!-- 画像の表示 -->
			<tr>
			<td>
					<span id="img">
						<img class="image"
							src="<s:property value='session.d_image_file_path'/>" alt="Photo"
							width="400" height="300">
					</span>
			</td>
			<td>
							<span id="productName">
								<!-- 商品名 -->
								<s:property value="session.d_product_name" /></span><br>
							<span id="productNameKana">
								<!-- 商品名かな -->
								<s:property value="session.d_product_name_kana" /></span>
								<br>

						<!-- カテゴリーによって値段表示変更 -->
						<span class="form-product">
						<s:if test="session.d_category_id==2">
						<p class="product_menu_size">
							<input type="radio" name="product" checked="checked" value='<s:property value="session.d_product_msize_price" />'><img class="image" src="./images/icon/m.png" alt="Photo" >￥<s:property value="session.d_product_msize_price" />
							<input type="radio" name="product" value='<s:property value="session.d_product_lsize_price" />'><img class="image" src="./images/icon/l.png" alt="Photo" >￥<s:property value="session.d_product_lsize_price" />
						</s:if>
						<s:if test="session.d_category_id==3 || session.d_category_id==4">
						<!-- サイド・ドリンク -->
							<p id="sAndDPrice" name="sAndDPrice" value='<s:property value="session.d_product_price" />'>￥<s:property value="session.d_product_price" /></p>
						</s:if></span>

							<div class="productDescription">
							<div class="productDescription1">商品詳細</div>
							<s:property value="session.d_product_description" /></div>
			</td>
			</tr>
	</table><br>


<s:if test="session.d_category_id==2">
	<table class="table-topping">
		<tr>
		<th>
		<div id="toppingtitle">
			Topping ￥324</div>
		</th>
		</tr>
		<tr>
		<td>
		<div class="productDescription">

			<span id="topping">
						<s:iterator value="session.toppingList" status="topping-number">

								<input type="checkbox" name="topping_id_<s:property value='topping_id'/>" value="<s:property value='msize_price'/>" class="topping_menu"  />
								<s:property value="topping_name" />
						</s:iterator>
			</span>
		</div>
		</td>
		</tr>
	</table>
</s:if><br><br>


	<p id="total1">
			Quantity:
			<s:select name="productCount" id="product_count" list="stockList"
				onchange="outputSelectedValueAndText(this);" />&nbsp;
			TotalAmount:
			<s:hidden name="total_price" id="total_price" />
			<span id="total_price_text"></span>
			<s:hidden name="productId" value="%{session.d_product_id}" ></s:hidden>
			<s:hidden name="gocart" value="1" />
			<s:submit value="カートに入れる" />
	</p>
	</s:form>
		<%--お気に入りボタン,非ログイン時は非表示 --%>
			<s:if test="#session.containsKey('userId')">
				<s:form action="FavoriteAction" name="favoriteInsertFlg" value="1">
					<span class="favlist">
						<s:submit value=" ★" onclick="FavoriteAction();" />
					</span>
				</s:form>
			</s:if><br><br>



	<hr class="line"><br>


	<table class="suggestProduct">
		<tr>
		<th>
			<span id="suggestProduct">
				その他おすすめ商品</span>
		</th>
		</tr>

			<s:iterator value="suggestList">
		<div id="suggest">
		<tr>
		<td>

				<a href="<s:url action="ProductDetailsAction">
				 <s:param name="product_id" value="%{product_id}" /></s:url>">
						<img class="image" src="<s:property value='image_file_path'/>
						" alt="Photo" width="250" height="200">
				</a>

		</td>
		</tr>
		<tr>
		<td>
								<s:property value="product_name" />
								<s:property value="product_name_kana" />
		</td>
		</tr>
		<tr>
		<td>
							<s:if test="category_id==2">
								M￥<s:property value="msize_price" />
								L￥<s:property value="lsize_price" />
							</s:if>
							<s:if test="category_id==3 || category_id==4">
								￥<s:property value="price" />
							</s:if>
						<s:hidden name="product_id" value="%{product_id}" />
		</td>
		</tr>
		</div>
		</s:iterator>

	</table>

	<!-- フッター -->
	<jsp:include page="include_footer.jsp" />
</body>
</html>