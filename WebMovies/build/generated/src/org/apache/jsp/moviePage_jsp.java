package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class moviePage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/header.jsp");
    _jspx_dependants.add("/search.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <!-- Fonts -->\n");
      out.write("        <!-- Font awesome - icon font -->\n");
      out.write("        <link href=\"font-awesome/css/font-awesome.min.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("        <!-- Stylesheets -->\n");
      out.write("        <!-- jQuery UI --> \n");
      out.write("        <link href=\"http://code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("        <!-- Mobile menu -->\n");
      out.write("        <link href=\"css/gozha-nav.css\" rel=\"stylesheet\" />\n");
      out.write("        <!-- Select -->\n");
      out.write("        <link href=\"css/external/jquery.selectbox.css\" rel=\"stylesheet\" />\n");
      out.write("        <!-- Swiper slider -->\n");
      out.write("        <link href=\"css/external/idangerous.swiper.css\" rel=\"stylesheet\" />\n");
      out.write("        <!-- Magnific-popup -->\n");
      out.write("        <link href=\"css/external/magnific-popup.css\" rel=\"stylesheet\" />\n");
      out.write("\n");
      out.write("\n");
      out.write("        <!-- Custom -->\n");
      out.write("        <link href=\"css/style.css?v=1\" rel=\"stylesheet\" />\n");
      out.write("\n");
      out.write("        <!-- Modernizr --> \n");
      out.write("        <script src=\"js/external/modernizr.custom.js\"></script>  \n");
      out.write("        <title>Movie</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"wrapper\">\n");
      out.write("            ");
      out.write("<!-- Banner -->\n");
      out.write("<div class=\"banner-top\">\n");
      out.write("    <img alt='top banner' src=\"images/banners/bra.jpg\" >\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<!-- Header section -->\n");
      out.write("<header class=\"header-wrapper\">\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <!-- Logo link-->\n");
      out.write("        <a href='index.html' class=\"logo\">\n");
      out.write("            <img alt='logo' src=\"images/logo.png\">\n");
      out.write("        </a>\n");
      out.write("\n");
      out.write("        <!-- Main website navigation-->\n");
      out.write("        <nav id=\"navigation-box\">\n");
      out.write("            <!-- Toggle for mobile menu mode -->\n");
      out.write("            <a href=\"#\" id=\"navigation-toggle\">\n");
      out.write("                <span class=\"menu-icon\">\n");
      out.write("                    <span class=\"icon-toggle\" role=\"button\" aria-label=\"Toggle Navigation\">\n");
      out.write("                        <span class=\"lines\"></span>\n");
      out.write("                    </span>\n");
      out.write("                </span>\n");
      out.write("            </a>\n");
      out.write("\n");
      out.write("            <!-- Link navigation -->\n");
      out.write("            <ul id=\"navigation\">\n");
      out.write("                <li>\n");
      out.write("                    <span class=\"sub-nav-toggle plus\"></span>\n");
      out.write("                    <a href=\"#\">Pages</a>\n");
      out.write("\n");
      out.write("                </li>\n");
      out.write("                <li>\n");
      out.write("                    <span class=\"sub-nav-toggle plus\"></span>\n");
      out.write("                    <a href=\"page-elements.html\">Features</a>\n");
      out.write("\n");
      out.write("                </li>\n");
      out.write("                <li>\n");
      out.write("                    <span class=\"sub-nav-toggle plus\"></span>\n");
      out.write("                    <a href=\"page-elements.html\">Booking steps</a>\n");
      out.write("\n");
      out.write("                </li>\n");
      out.write("                <li>\n");
      out.write("                    <span class=\"sub-nav-toggle plus\"></span>\n");
      out.write("                    <a href=\"gallery-four.html\">Gallery</a>\n");
      out.write("\n");
      out.write("                </li>\n");
      out.write("                <li>\n");
      out.write("                    <span class=\"sub-nav-toggle plus\"></span>\n");
      out.write("                    <a href=\"news-left.html\">News</a>\n");
      out.write("\n");
      out.write("                </li>\n");
      out.write("                <li>\n");
      out.write("                    <span class=\"sub-nav-toggle plus\"></span>\n");
      out.write("                    <a href=\"#\">Mega menu</a>\n");
      out.write("\n");
      out.write("                </li>\n");
      out.write("            </ul>\n");
      out.write("        </nav>\n");
      out.write("\n");
      out.write("        <!-- Additional header buttons / Auth and direct link to booking-->\n");
      out.write("        <div class=\"control-panel\">\n");
      out.write("            <a href=\"#\" class=\"btn btn--sign login-window\">Sign in</a>            \n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("</header>        \n");
      out.write("\n");
      out.write("<!-- open/close -->\n");
      out.write("<div class=\"overlay overlay-hugeinc\">\n");
      out.write("\n");
      out.write("    <section class=\"container\">\n");
      out.write("\n");
      out.write("        <div class=\"col-sm-4 col-sm-offset-4\">\n");
      out.write("            <button type=\"button\" class=\"overlay-close\">Close</button>\n");
      out.write("            <form class=\"login\" method=\"post\" action=\"Login?user=user\" >\n");
      out.write("                <p class=\"login__title\">sign in <br><span class=\"login-edition\">welcome to A.Movie</span></p>\n");
      out.write("\n");
      out.write("                <div class=\"social social--colored\">\n");
      out.write("                    <a href='#' class=\"social__variant fa fa-facebook\"></a>\n");
      out.write("                    <a href='#' class=\"social__variant fa fa-twitter\"></a>\n");
      out.write("                    <a href='#' class=\"social__variant fa fa-tumblr\"></a>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <p class=\"login__tracker\">or</p>\n");
      out.write("\n");
      out.write("                <div class=\"field-wrap\">\n");
      out.write("                    <input placeholder='UserName' name=\"username\" class=\"login__input\">\n");
      out.write("                    <input type=\"password\" placeholder='Password' name=\"pass\" class=\"login__input\">\n");
      out.write("\n");
      out.write("                    <input type='checkbox' id='#informed' class='login__check styled'>\n");
      out.write("                    <label for='#informed' class='login__check-info'>remember me</label>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"login__control\">\n");
      out.write("                    <input type=\"submit\" value=\"sign in\" class=\"btn btn-md btn--warning btn--wider\">\n");
      out.write("                    <a href=\"#\" class=\"login__tracker form__tracker\">Forgot password?</a>\n");
      out.write("                </div>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("    </section>\n");
      out.write("</div>");
      out.write("\n");
      out.write("            ");
      out.write("<!-- Search bar -->\n");
      out.write("<div class=\"search-wrapper\">\n");
      out.write("    <div class=\"container container--add\">\n");
      out.write("        <form id='search-form' method='get' class=\"search\">\n");
      out.write("            <input type=\"text\" class=\"search__field\" placeholder=\"Search\">\n");
      out.write("            <select name=\"sorting_item\" id=\"search-sort\" class=\"search__sort\" tabindex=\"0\">\n");
      out.write("                <option value=\"category\" selected='selected'>By Category</option>\n");
      out.write("                <option value=\"name\">By Name</option>\n");
      out.write("            </select>\n");
      out.write("            <button type='submit' class=\"btn btn-md btn--danger search__button\">search a movie</button>\n");
      out.write("        </form>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            <section class=\"container\">\n");
      out.write("                <div class=\"col-sm-8 col-md-9\">\n");
      out.write("                    <div class=\"movie\">\n");
      out.write("                        <h2 class=\"page-heading\">The Hobbit: An Unexpected Journey</h2>\n");
      out.write("\n");
      out.write("                        <div class=\"movie__info\">\n");
      out.write("                            <div class=\"col-sm-6 col-md-4 movie-mobile\">\n");
      out.write("                                <div class=\"movie__images\">\n");
      out.write("                                    <span class=\"movie__rating\">5.0</span>\n");
      out.write("                                    <img alt='' src=\"images/movie/single-movie.jpg\">\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"movie__rate\">Your vote: <div id='score' class=\"score\"></div></div>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <div class=\"col-sm-6 col-md-8\">\n");
      out.write("                                <p class=\"movie__time\">169 min</p>\n");
      out.write("\n");
      out.write("                                <p class=\"movie__option\"><strong>Country: </strong><a href=\"#\">New Zeland</a>, <a href=\"#\">USA</a></p>\n");
      out.write("                                <p class=\"movie__option\"><strong>Year: </strong><a href=\"#\">2012</a></p>\n");
      out.write("                                <p class=\"movie__option\"><strong>Category: </strong><a href=\"#\">Adventure</a>, <a href=\"#\">Fantazy</a></p>\n");
      out.write("                                <p class=\"movie__option\"><strong>Release date: </strong>December 12, 2012</p>\n");
      out.write("                                <p class=\"movie__option\"><strong>Director: </strong><a href=\"#\">Peter Jackson</a></p>\n");
      out.write("                                <p class=\"movie__option\"><strong>Actors: </strong><a href=\"#\">Martin Freeman</a>, <a href=\"#\">Ian McKellen</a>, <a href=\"#\">Richard Armitage</a>, <a href=\"#\">Ken Stott</a>, <a href=\"#\">Graham McTavish</a>, <a href=\"#\">Cate Blanchett</a>, <a href=\"#\">Hugo Weaving</a>, <a href=\"#\">Ian Holm</a>, <a href=\"#\">Elijah Wood</a> <a href=\"#\">...</a></p>\n");
      out.write("                                <p class=\"movie__option\"><strong>Age restriction: </strong><a href=\"#\">13</a></p>\n");
      out.write("                                <p class=\"movie__option\"><strong>Box office: </strong><a href=\"#\">$1 017 003 568</a></p>\n");
      out.write("\n");
      out.write("                                <a href=\"#\" class=\"comment-link\">Comments:  15</a>\n");
      out.write("\n");
      out.write("                                <div class=\"movie__btns\">\n");
      out.write("                                    <a href=\"#\" class=\"btn btn-md btn--warning\">book a ticket for this movie</a>\n");
      out.write("                                    <a href=\"#\" class=\"watchlist\">Add to watchlist</a>\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                                <div class=\"share\">\n");
      out.write("                                    <span class=\"share__marker\">Share: </span>\n");
      out.write("                                    <div class=\"addthis_toolbox addthis_default_style \">\n");
      out.write("                                        <a class=\"addthis_button_facebook_like\" fb:like:layout=\"button_count\"></a>\n");
      out.write("                                        <a class=\"addthis_button_tweet\"></a>\n");
      out.write("                                        <a class=\"addthis_button_google_plusone\" g:plusone:size=\"medium\"></a>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"clearfix\"></div>\n");
      out.write("\n");
      out.write("                        <h2 class=\"page-heading\">The plot</h2>\n");
      out.write("\n");
      out.write("                        <p class=\"movie__describe\">Bilbo Baggins is swept into a quest to reclaim the lost Dwarf Kingdom of Erebor from the fearsome dragon Smaug. Approached out of the blue by the wizard Gandalf the Grey, Bilbo finds himself joining a company of thirteen dwarves led by the legendary warrior, Thorin Oakenshield. Their journey will take them into the Wild; through treacherous lands swarming with Goblins and Orcs, deadly Wargs and Giant Spiders, Shapeshifters and Sorcerers. Although their goal lies to the East and the wastelands of the Lonely Mountain first they must escape the goblin tunnels, where Bilbo meets the creature that will change his life forever ... Gollum. Here, alone with Gollum, on the shores of an underground lake, the unassuming Bilbo Baggins not only discovers depths of guile and courage that surprise even him, he also gains possession of Gollum's \"precious\" ring that holds unexpected and useful qualities ... A simple, gold ring that is tied to the fate of all Middle-earth in ways Bilbo cannot begin to ... </p>\n");
      out.write("\n");
      out.write("                        <h2 class=\"page-heading\">photos &amp; videos</h2>\n");
      out.write("\n");
      out.write("                        <div class=\"movie__media\">\n");
      out.write("                            <div class=\"movie__media-switch\">\n");
      out.write("                                <a href=\"#\" class=\"watchlist list--photo\" data-filter='media-photo'>234 photos</a>\n");
      out.write("                                <a href=\"#\" class=\"watchlist list--video\" data-filter='media-video'>10 videos</a>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <div class=\"swiper-container\">\n");
      out.write("                                <div class=\"swiper-wrapper\">\n");
      out.write("                                    <!--First Slide-->\n");
      out.write("                                    <div class=\"swiper-slide media-video\">\n");
      out.write("                                        <a href='https://www.youtube.com/watch?v=Y5AehBA3IsE' class=\"movie__media-item \">\n");
      out.write("                                            <img alt='' src=\"images/movie/movie-video1.jpg\">\n");
      out.write("                                        </a>\n");
      out.write("                                    </div>\n");
      out.write("\n");
      out.write("                                    <!--Second Slide-->\n");
      out.write("                                    <div class=\"swiper-slide media-video\">\n");
      out.write("                                        <a href='https://www.youtube.com/watch?v=Kb3ykVYvT4U' class=\"movie__media-item\">\n");
      out.write("                                            <img alt='' src=\"images/movie/movie-video2.jpg\">\n");
      out.write("                                        </a>\n");
      out.write("                                    </div>\n");
      out.write("\n");
      out.write("                                    <!--Third Slide-->\n");
      out.write("                                    <div class=\"swiper-slide media-photo\"> \n");
      out.write("                                        <a href='images/movie/movie-img1-lg.jpg' class=\"movie__media-item\">\n");
      out.write("                                            <img alt='' src=\"images/movie/movie-img1.jpg\">\n");
      out.write("                                        </a>\n");
      out.write("                                    </div>\n");
      out.write("\n");
      out.write("                                    <!--Four Slide-->\n");
      out.write("                                    <div class=\"swiper-slide media-photo\"> \n");
      out.write("                                        <a href='images/movie/movie-img2-lg.jpg' class=\"movie__media-item\">\n");
      out.write("                                            <img alt='' src=\"images/movie/movie-img2.jpg\">\n");
      out.write("                                        </a>\n");
      out.write("                                    </div>\n");
      out.write("\n");
      out.write("                                    <!--Slide-->\n");
      out.write("                                    <div class=\"swiper-slide media-photo\"> \n");
      out.write("                                        <a href='images/gallery/large/item-7.jpg' class=\"movie__media-item\">\n");
      out.write("                                            <img alt='' src=\"images/movie/movie-img3.jpg\">\n");
      out.write("                                        </a>\n");
      out.write("                                    </div>\n");
      out.write("\n");
      out.write("                                    <!--Slide-->\n");
      out.write("                                    <div class=\"swiper-slide media-photo\"> \n");
      out.write("                                        <a href='images/gallery/large/item-11.jpg' class=\"movie__media-item\">\n");
      out.write("                                            <img alt='' src=\"images/movie/movie-img4.jpg\">\n");
      out.write("                                        </a>\n");
      out.write("                                    </div>\n");
      out.write("\n");
      out.write("                                    <!--First Slide-->\n");
      out.write("                                    <div class=\"swiper-slide media-video\">\n");
      out.write("                                        <a href='https://www.youtube.com/watch?v=Y5AehBA3IsE' class=\"movie__media-item \">\n");
      out.write("                                            <img alt='' src=\"images/movie/movie-video1.jpg\">\n");
      out.write("                                        </a>\n");
      out.write("                                    </div>\n");
      out.write("\n");
      out.write("                                    <!--Second Slide-->\n");
      out.write("                                    <div class=\"swiper-slide media-video\">\n");
      out.write("                                        <a href='https://www.youtube.com/watch?v=Kb3ykVYvT4U' class=\"movie__media-item\">\n");
      out.write("                                            <img alt='' src=\"images/movie/movie-video2.jpg\">\n");
      out.write("                                        </a>\n");
      out.write("                                    </div>\n");
      out.write("\n");
      out.write("                                    <!--Slide-->\n");
      out.write("                                    <div class=\"swiper-slide media-photo\"> \n");
      out.write("                                        <a href='images/gallery/large/item-15.jpg' class=\"movie__media-item\">\n");
      out.write("                                            <img alt='' src=\"images/movie/movie-img5.jpg\">\n");
      out.write("                                        </a>\n");
      out.write("                                    </div>\n");
      out.write("\n");
      out.write("                                    <!--Slide-->\n");
      out.write("                                    <div class=\"swiper-slide media-photo\"> \n");
      out.write("                                        <a href='images/gallery/large/item-16.jpg' class=\"movie__media-item\">\n");
      out.write("                                            <img alt='' src=\"images/movie/movie-img6.jpg\">\n");
      out.write("                                        </a>\n");
      out.write("                                    </div>\n");
      out.write("\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </section>\n");
      out.write("\n");
      out.write("            <!-- JavaScript-->\n");
      out.write("            <!-- jQuery 1.9.1--> \n");
      out.write("            <script src=\"js/external/jquery-1.10.1.min.js\"></script>\n");
      out.write("\n");
      out.write("            <script src=\"js/external/jquery-migrate-1.2.1.min.js\"></script>\n");
      out.write("            <!-- jQuery UI -->\n");
      out.write("            <script src=\"http://code.jquery.com/ui/1.10.4/jquery-ui.js\"></script>\n");
      out.write("            <!-- Bootstrap 3--> \n");
      out.write("            <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("\n");
      out.write("            <!-- Select -->\n");
      out.write("            <script src=\"js/external/jquery.selectbox-0.2.min.js\"></script>\n");
      out.write("\n");
      out.write("            <!-- Stars rate -->\n");
      out.write("            <script src=\"js/external/jquery.raty.js\"></script>\n");
      out.write("\n");
      out.write("\n");
      out.write("            <!-- Form element -->\n");
      out.write("            <script src=\"js/external/form-element.js\"></script>\n");
      out.write("            <!-- Form validation -->\n");
      out.write("            <script src=\"js/form.js\"></script>\n");
      out.write("\n");
      out.write("            <!-- Custom -->\n");
      out.write("            <script src=\"js/custom.js\"></script>\n");
      out.write("\n");
      out.write("            <script type=\"text/javascript\">\n");
      out.write("        $(document).ready(function() {\n");
      out.write("            init_MoviePage();\n");
      out.write("        });\n");
      out.write("            </script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
