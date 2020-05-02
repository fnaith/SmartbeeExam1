import React from 'react';
import Grid from '@material-ui/core/Grid';

import CompanyInfoList from './CompanyInfoList';

const CompanyControl = function () {
  return (
    <div>
      <Grid container>
        <Grid item xs={12}>
          <CompanyInfoList />
        </Grid>
      </Grid>
    </div>
  )
}

export default CompanyControl;
