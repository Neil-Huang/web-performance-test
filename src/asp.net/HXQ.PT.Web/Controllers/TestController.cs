using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace HXQ.PT.Web.Controllers
{
    public class TestController : Controller
    {

        public ActionResult Query(int ms = 0)
        {
            if (ms > 0)
            {
                System.Threading.Thread.Sleep(ms);
            }
            string strNow = DateTime.Now.ToString("yyyy-MM-dd HH:mm:ss fff");
            return Content(strNow);
        }

        public ActionResult QueryEx(int ms = 0)
        {
            if (ms > 0)
            {
                System.Threading.Thread.Sleep(ms);
            }

            string strNow = DateTime.Now.ToString("yyyy-MM-dd HH:mm:ss fff");
            var result = new ResultModel()
            {
                nowtime = strNow,
                ms = ms
            };
            return Json(result, JsonRequestBehavior.AllowGet);
        }

        public class ResultModel
        {
            public string nowtime { get; set; }
            public int ms { get; set; }
        }
    }
}