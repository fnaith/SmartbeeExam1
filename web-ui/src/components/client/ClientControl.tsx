import React from 'react';
import Grid from '@material-ui/core/Grid';

import ClientInfoList from './ClientInfoList';

const ClientControl = function () {
  return (
    <div>
      <Grid container>
        <Grid item xs={12}>
          <ClientInfoList />
        </Grid>
      </Grid>
    </div>
  )
}

export default ClientControl;
