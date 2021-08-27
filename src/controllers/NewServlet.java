package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Task;

/**
 * Servlet implementation class NewServlet
 */
@WebServlet("/new")
public class NewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //CSRF対策
        request.setAttribute("_token", request.getSession().getId());

        //インスタンスの生成
        request.setAttribute("task", new Task());

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/tasks/new.jsp");
        rd.forward(request, response);

        /*
         * NewServlet動作確認のためのコード（メモ）
        EntityManager em = DBUtil.createEntityManager();
        em.getTransaction().begin();

        //Taskのインスタンスを生成
        Task t = new Task();

        //tのフィールドにデータを代入
        //タスク内容
        String content = "夕飯の買い出しに行く";
        t.setContent(content);

        //現在の日時を取得
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        t.setCreated_at(currentTime);
        t.setUpdated_at(currentTime);

        //データベースに保存
        em.persist(t);
        em.getTransaction().commit();

        //自動採番されたIDの値を表示
        response.getWriter().append(Integer.valueOf(t.getId()).toString());

        em.close();

        */

    }

}
