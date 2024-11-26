<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Encabezado aCuenta</title>
    <link rel="stylesheet" href="../styles.css">
</head>
<body>
<div id="header-container" class="header-container">
    <header class="header">
        <div class="header-main">
            <!-- Logo -->
            <div role="button" tabindex="0" class="logo">
                <a href="${pageContext.request.contextPath}/index.jsp">
                    <img
                            data-chromatic="ignore"
                            itemprop="logo"
                            class="logo-img"
                            src="${pageContext.request.contextPath}/images/logo_miscanti.jpg"
                            alt="Miscanti"
                    />
                </a>
            </div>


            <!-- Botón Productos -->
            <button class="header-products">
                <a href="${pageContext.request.contextPath}/productos.jsp">
                    Productos
                </a>
            </button>

            <!-- Barra de búsqueda -->
            <div class="header-search">
                <form action="<%= request.getContextPath() %>/search" method="get" style="display: flex; width: 100%; align-items: center;">
                    <input type="search" name="query" placeholder="Buscar en Miscanti" />
                    <button type="submit" class="search-btn">
                        Buscar
                    </button>
                </form>
            </div>


            <!-- Boton login -->
            <button
                    onclick="window.location.href='<%= session.getAttribute("username") != null ? "account.jsp" : "login.jsp" %>'"
                    class="header-account-btn">
                <div class="account-menu-icon">
                    <!-- Imagen del ícono -->
                    <img
                            src="${pageContext.request.contextPath}/images/account_icon.png"
                            alt="Cuenta"
                            class="account-icon-img" />
                </div>
                <div class="account-menu-content">
                    <!-- Texto dinámico -->
                    <span>
            ¡Hola, <%= session.getAttribute("username") != null ? session.getAttribute("username") : "Inicia sesión" %>!
        </span>
                </div>
            </button>



            <!-- Icono Carrito -->
            <div class="header-icons">
                <button class="cart-btn">
                    <img src="${pageContext.request.contextPath}/images/cart_icon.png" alt="Carrito" class="cart-icon-img" />
                    <span>Carrito (<%= session.getAttribute("cartCount") != null ? session.getAttribute("cartCount") : "0" %>)</span>
                </button>
            </div>


        </div>
    </header>
</div>
</body>
</html>
