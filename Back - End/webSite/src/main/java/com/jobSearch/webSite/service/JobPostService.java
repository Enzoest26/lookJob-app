package com.jobSearch.webSite.service;

import com.jobSearch.webSite.model.JobPost;
import com.jobSearch.webSite.repository.JobPostRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class JobPostService {

    @Autowired
    private JobPostRepository jobPostRepository;

    @Autowired
    JdbcTemplate jdbcTemplate;

    //Methods to post a job
    @Transactional
    public JobPost postJob(JobPost jobPost){

        try {
            Long lastId = Long.valueOf(jdbcTemplate.queryForObject("select MAX(id_jpost) from tb_jobpost", Integer.class) + 1) ;
            List<String> listRequiriments = jobPost.getRequirements();
            List<Integer> listTypesJobs = jobPost.getTypesJob();

            int result = jdbcTemplate.update("insert into tb_jobpost(id_jpost, title_jpost, id_company, direction, content_jpost)" +
                            " values(?,?,?,?,?)",lastId, jobPost.getTitle(), jobPost.getIdCompany(), jobPost.getDirection(),
                    jobPost.getContent());
            //Methods of insertion

            result += addRequiPost(lastId,listRequiriments);
            result += addTypesJobs(lastId, listTypesJobs);

            return jobPost;
        }catch (Exception e){
            System.out.println("Error en: " + e.getMessage());
            //return "Error in uploading the class : " + e.getMessage();
            return null;
        }

    }
    private int addTypesJobs(Long id, List<Integer> listTypesJobs) {
        try{
            for(int i = 0; i< listTypesJobs.size(); i++){
                jdbcTemplate.update("insert into tb_post_types(id_jpost, id_type) values(?,?)",id,listTypesJobs.get(i));
            }
            return 1;
        }catch (Exception e){
            System.out.println("Error en TypesJobs: " + e.getMessage());
            return -1;
        }
    }
    private int addRequiPost(Long id, List<String> listRequi) {
        try{
            for(int i = 0; i< listRequi.size(); i++){
                jdbcTemplate.update("insert into tb_postrequi values(?,?)", id, listRequi.get(i));
            }
            return 1;
        }catch (Exception e){
            System.out.println("Error en RequiPost: " + e.getMessage());
            return -1;
        }
    }

    //Method to list all the job
    public List<JobPost> listPostsJobs(){
        List<JobPost> listJobs = jobPostRepository.findAll();
        for (JobPost jobPost: listJobs) {
            //setRequirements(getRequiPost(jobPost.getId()));
            jobPost.setTypesJob(getTypesJobsPost(jobPost.getId()));
        }
        return listJobs;
    }
    private List<Integer> getTypesJobsPost(Long id){
        String sql = "select id_type from tb_post_types where id_jpost = ?";
        List<Integer> listTypes = jdbcTemplate.query(sql, new Object[]{id}, new RowMapper<Integer>() {
            @Override
            public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
                return rs.getInt("id_type");
            }
        });
        return listTypes;
    }
    private List<String> getRequiPost(Long id){
        String sql = "select requi_jpost from tb_postrequi where id_jpost = ?";
        List<String> listRequi = jdbcTemplate.query(sql, new Object[]{id}, new RowMapper<String>() {
            @Override
            public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                String requi = "";
                return requi = rs.getString("requi_jpost");
            }
        });
        return listRequi;
    }

    //Method to list only one job
    public Optional<JobPost> getOnlyJobPost(Long id){
        Optional<JobPost> getJob = jobPostRepository.findById(id);
        getJob.get().setRequirements(getRequiPost(id));
        getJob.get().setTypesJob(getTypesJobsPost(id));
        return getJob;
    }
}
