import React from 'react';
import Grid from '@material-ui/core/Grid';

import AddCompanyForm from './AddCompanyForm';
import SubmitCompanyForm from './SubmitCompanyForm';
import CompanyFormList from './CompanyFormList';

const CreateCompany = function () {
  return (
    <div>
      <Grid container>
        <Grid item xs={4}>
          <AddCompanyForm />
        </Grid>
        <Grid item xs={4}>
          <SubmitCompanyForm />
        </Grid>
        <Grid item xs={12}>
          <CompanyFormList />
        </Grid>
      </Grid>
    </div>
  )
}

export default CreateCompany;
