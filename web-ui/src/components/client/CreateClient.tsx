import React from 'react';
import Grid from '@material-ui/core/Grid';

import AddClientForm from './AddClientForm';
import SubmitClientForm from './SubmitClientForm';
import ClientFormList from './ClientFormList';

const CreateClient = function () {
  return (
    <div>
      <Grid container>
        <Grid item xs={4}>
          <AddClientForm />
        </Grid>
        <Grid item xs={4}>
          <SubmitClientForm />
        </Grid>
        <Grid item xs={12}>
          <ClientFormList />
        </Grid>
      </Grid>
    </div>
  )
}

export default CreateClient;
